package com.mg.node.db.sql.build;

import com.itranswarp.compiler.JavaStringCompiler;

import javax.jws.Oneway;
import java.io.IOException;
import java.util.Map;

public class ClassBuild {

    public Class cl =null;

    static ClassBuild build = null;

    public static ClassBuild single()
    {
        if(build==null)
        {
            build = new ClassBuild();
            try {
                build.cl = build.getAddClass();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return build;


    }

    private Class getAddClass() throws IOException, ClassNotFoundException {
        // 声明类名
        String className = "UserTemplate";
        String packageName = "com.mg.node.db.sql.build";
//        // 声明包名：package top.fomeiherz;
//        String prefix = String.format("package %s;", packageName);
//        // 全类名：top.fomeiherz.Main
        String fullName = String.format("%s.%s", packageName, className);

        // 传入String类型的代码
        String source = "package com.mg.node.db.sql.build;\n" +
                "\n" +
                "import com.mg.node.db.sql.pojo.RmtActiorInfo;\n" +
                "import com.mg.node.db.sql.pojo.RmtUserInfo;\n" +
                "import org.apache.ibatis.annotations.Param;\n" +
                "import org.apache.ibatis.annotations.Select;\n"+
                "import com.mg.node.db.sql.imp.ITemplate;"+
                "public interface UserTemplate extends ITemplate<RmtUserInfo>{\n" +
                "\n" +
                "    @Select(\"select * from rmt_actior_info where id=#{id}\")\n" +
                "    RmtUserInfo getById(@Param(\"id\") String id);\n" +
                "\n" +
                "    @Select(\"${sql}\")\n" +
                "    RmtUserInfo getBySql(@Param(\"sql\") String id);\n" +
                "\n" +
                "}";
        JavaStringCompiler compiler = new JavaStringCompiler();
        System.out.println(source);
        // 编译：compiler.compile("Main.java", source)
        Map<String, byte[]> results = compiler.compile(className + ".java", source);
        // 加载内存中byte到Class<?>对象
        Class<?> clazz = compiler.loadClass(fullName, results);
        return clazz;
    }
}
