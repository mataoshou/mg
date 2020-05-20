//package com.mg.node.common.generate.cache;
//
//import java.io.IOException;
//
//public class CreateCache extends ICreate {
//    public CreateCache(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
//        super(actionName, toolClass, pojoClass, methods, sysName);
//    }
//
//    @Override
//    protected ClassBuildUtil createClass() throws IOException {
//
//        ClassBuildUtil cacheClassBuildUtil = new ClassBuildUtil();
//
//        cacheClassBuildUtil.classInit(this.getClassName(),String.format("IBaseCache<%s,%s>",this.getItem().getPojoClassName(),this.getItem().getToolClassName()),
//                null, this.getPackageName(),
//                new String[]{"Service","Slf4j"},true,
//                new String[]{this.getItem().getPojoClassFullName(),
//                        this.getItem().getToolClassFullName(),
//                        "lombok.extern.slf4j.Slf4j",
//                        "org.springframework.stereotype.Service",
//                        "com.mg.base.common.base.util.SpringUtil",
//                        CacheConstant.CACHE_CONSTANT_PACKAGE+"." +this.getConstantClassName(),
//                        ConvertsConstant.POJO_PACKAGE+".QueryItem",
//                        ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItem",
//                        "java.util.List",
//                        "org.springframework.beans.factory.annotation.Autowired",
//                        String.format("%s.%sFeign", FeignConstant.FEIGN_PACKAGE,this.getName())});
//
//        return cacheClassBuildUtil;
//
//    }
//
//    @Override
//    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
//        classBuildUtil.addTabContent(String.format("public void initCache()"));
//        classBuildUtil.addTabContent(String.format("{"));
//        classBuildUtil.addTabRightContent(String.format("setCommonutil(SpringUtil.getBean(%s.class));",this.getItem().getToolClassName()));
//        classBuildUtil.addTabContent(String.format("setCacheDecorate(%s.CACHE_PRE,%s.CACHE_LAST);",this.getConstantClassName(),this.getConstantClassName()));
//        classBuildUtil.addTabLeftContent("}");
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected boolean check(String key) {"));
//        classBuildUtil.addTabRightContent(String.format("return true;"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected boolean success(String key, List<%s> pojos) {",this.getItem().getPojoClassName()));
//        classBuildUtil.addTabRightContent(String.format("return true;"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected boolean fail(String key, List<%s> pojos, Exception e) {",this.getItem().getPojoClassName()));
//        classBuildUtil.addTabRightContent(String.format("return true;"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected String getKeyParams(%s pojo) {",this.getItem().getPojoClassName()));
//        classBuildUtil.addTabRightContent(String.format("return pojo.getId();"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent("@Autowired");
//        classBuildUtil.addTabContent(String.format("%sFeign feign;",this.getName()));
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected CommonItem selectListByDB(QueryItem queryItem) {"));
//        classBuildUtil.addTabRightContent(String.format("return feign.list(queryItemCommonUtil.toCommon(queryItem));"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected CommonItem getPojoByDB(QueryItem queryItem) {"));
//        classBuildUtil.addTabRightContent(String.format("return feign.get(queryItemCommonUtil.toCommon(queryItem));"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected CommonItem updatePojoByDB(%s pojo) {",this.getItem().getPojoClassName()));
//        classBuildUtil.addTabRightContent(String.format("return feign.edit(commonutil.toCommon(pojo));"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//        classBuildUtil.addTabContent("\r\n");
//
//
//        classBuildUtil.addTabContent(String.format("@Override"));
//        classBuildUtil.addTabContent(String.format("protected void deletePojoByDB(%s pojo) {",this.getItem().getPojoClassName()));
//        classBuildUtil.addTabRightContent(String.format("feign.delete(commonutil.toCommon(pojo));"));
//        classBuildUtil.addTabLeftContent(String.format("}"));
//    }
//
//    @Override
//    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
//
//    }
//
//    @Override
//    protected void createLastMethod(ClassBuildUtil classBuildUtil) throws IOException {
//
//    }
//
//    @Override
//    protected ClassBuildUtil createConstantClass() throws IOException {
//        ClassBuildUtil constantClassBuildUtil = new ClassBuildUtil();
//
//        constantClassBuildUtil.classInit(this.getConstantClassName(), CacheConstant.CACHE_CONSTANT_PACKAGE,true,null);
//
//        return constantClassBuildUtil;
//    }
//
//    @Override
//    protected void createConstantPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
//        classBuildUtil.addTabContent(String.format("public static final String CACHE_PRE = CacheConstant.REDIS_KEY_PRE+\"%s\";",this.getName().toUpperCase()));
//
//        classBuildUtil.addTabContent("");
//
//        classBuildUtil.addTabContent("public static final String CACHE_LAST = \"\" + CacheConstant.REDIS_KEY_LAST;");
//    }
//
//    @Override
//    protected void createConstantMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
//
//    }
//
//    @Override
//    protected void classInit() {
//
//    }
//
//    @Override
//    protected String getPackageName() {
//        return CacheConstant.CACHE_PACKAGE;
//    }
//
//    @Override
//    protected boolean isCreateConstant() {
//        return true;
//    }
//
//    @Override
//    protected String getConstantPackageName() {
//        return CacheConstant.CACHE_CONSTANT_PACKAGE;
//    }
//
//    @Override
//    protected String getClassNameLast() {
//        return "Cache";
//    }
//
//    @Override
//    protected String getConstantClassNameLast() {
//        return "CacheConstant";
//    }
//
//}
