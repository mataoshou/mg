//package com.mg.node.common.plugin.mybatis.page;
//
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.RowBounds;
//import sun.plugin2.main.server.ResultHandler;
//
//import java.util.Properties;
//import java.util.concurrent.Executor;
//
//@Intercepts({
//        @Signature(type = Executor.class, method = "update", args = {
//                MappedStatement.class, Object.class }),
//        @Signature(type = Executor.class, method = "query", args = {
//                MappedStatement.class, Object.class, RowBounds.class,
//                ResultHandler.class }) })
//public class MgPageInterceptor  implements Interceptor {
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        return null;
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return null;
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//}
