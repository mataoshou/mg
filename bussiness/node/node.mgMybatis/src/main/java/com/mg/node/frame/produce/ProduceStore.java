package com.mg.node.frame.produce;

import com.itranswarp.compiler.JavaStringCompiler;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.node.db.sql.pojo.RmtActiorInfo;
import com.mg.node.frame.imp.IGeneralMapper;
import com.mg.node.frame.template.GeneralTemplate;
import com.mg.node.frame.template.TemplateReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.*;


@Slf4j
public class ProduceStore {

    Map<String, List<ProduceItem>> m_map = new HashMap();

    List<String> m_scan = new ArrayList();

    public static ProduceStore store;


    private Class defTemplate = GeneralTemplate.class;
    private Class defImp = IGeneralMapper.class;


    public static ProduceStore single()
    {
        if(store==null)
        {
            store = new ProduceStore();
        }
        return store;
    }

    public void addPojo(Class pojo){
        addPojo(pojo,this.defTemplate,this.defImp);
    }

    public void addPojo(Class pojo,Class template,Class imp){
        log.info("{}添加至mapper列表",pojo.getName());
        ProduceItem item = new ProduceItem();
        item.setPojo(pojo);
        item.setTemplate(template);
        item.setImp(imp);
        List<ProduceItem> list = m_map.get(pojo.getSimpleName());
        if(list==null){
            list = new ArrayList<>();
        }
        list.add(item);
        m_map.put(pojo.getSimpleName(),list);
    }

    public void setScan(String packageName) throws IOException, ClassNotFoundException {
        this.m_scan.add(packageName);
        String path =String.format("classpath*:/%s/*.class",packageName.replace(".","/"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metaReader = new CachingMetadataReaderFactory();
        Resource[] resources = resolver.getResources(path);
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        for (Resource resource : resources) {
            MetadataReader reader = metaReader.getMetadataReader(resource);
            String className = reader.getClassMetadata().getClassName();
            Class<?> clazz = loader.loadClass(className);
            addPojo(clazz);
        }
    }


    public List<ProduceItem> getMapperClass(Class pojo)
    {
        return null;
    }

    public Set<String> eachKey()
    {
        return m_map.keySet();
    }


    private Class buildClass(ProduceItem item) throws IOException, ClassNotFoundException {

        String pojoName = item.getPojo().getSimpleName();



        // 声明类名
        String mapperName = item.getPojo().getSimpleName()+"Mapper";
        String packageName =  item.getPojo().getPackage().getName() + ".mapper";

        String impName =item.getImp().getSimpleName();
        String impFullName =item.getImp().getName();
        String impPackage = item.getImp().getPackage().getName();

        String fullName = String.format("%s.%s", packageName, mapperName);

        ClassUnit unit = new ClassUnit();
        unit.setName(mapperName);
        unit.setPackageName(packageName);
        unit.setBaseName(impName);
        unit.setType(2);

        unit.addImport(impFullName);
        unit.addImport("org.apache.ibatis.annotations.Select");

        Class template = item.getTemplate();

        String content = template.toGenericString();
        System.out.println("......"+content);
        String pStr;
        Method[] methods = template.getMethods();
        for (Method method : methods) {
            content = method.toString();
            System.out.println("......"+content);
            MethodUnit methodUnit = new MethodUnit();
            methodUnit.setName(method.getName());
            methodUnit.setType(2);

            Type returnParam = method.getGenericReturnType();
            String returnStr ="";
            if(returnParam instanceof List)
            {
                returnStr =String.format("List<%s>",item.getPojo().getSimpleName());
            }
            else if(returnParam.equals(TemplateReturn.class)){
                returnStr =String.format("%s",item.getPojo().getSimpleName());
            }
            else if(returnParam.equals(Object.class))
            {
                returnStr =method.getReturnType().getSimpleName();
            }

            methodUnit.setReturnValue(returnStr);

            Annotation[] annotations = method.getAnnotations();

            for(Annotation annotation : annotations)
            {
               String annStr = annotation.toString().substring(1).replace("[","\"").replace("]","\"");
               methodUnit.addAnnotation(annStr);
            }

            Parameter[] ps = method.getParameters();
            for (Parameter p : ps) {
//                pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
                methodUnit.addParam(p.getType().getSimpleName(),p.getName());
            }
            log.info(methodUnit.getContent());
        }



        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> results = compiler.compile(mapperName + ".java", "");
        // 加载内存中byte到Class<?>对象
        Class<?> clazz = compiler.loadClass(fullName, results);
        return clazz;
    }

    public ProduceItem setItem(Class pojo)
    {
        ProduceItem item = new ProduceItem();
        item.setPojo(pojo);
        item.setTemplate(this.defTemplate);
        item.setImp(this.defImp);
        return item;
    }


    public Map initParam()
    {
        Map params = new HashMap();
        params.put("##tableName##","");

        return params;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProduceItem item = ProduceStore.single().setItem(RmtActiorInfo.class);
        ProduceStore.single().buildClass(item);
    }

}
