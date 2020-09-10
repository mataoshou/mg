//package com.mg.website.common.config;
//
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Collection;
//
//public class MyFilterSecurityMetadataSource  implements FilterInvocationSecurityMetadataSource {
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        FilterInvocation fi = (FilterInvocation) object;
//        HttpServletRequest request = fi.getRequest();
//        String url = fi.getRequestUrl();
//        String httpMethod = fi.getRequest().getMethod();
//
//        // Lookup your database (or other source) using this information and populate the
//        // list of attributes (这里初始话你的权限数据)
//        //List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
//
//        //遍历我们初始化的权限数据，找到对应的url对应的权限
////        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
////                .entrySet()) {
////            if (entry.getKey().matches(request)) {
////                return entry.getValue();
////            }
////        }
//        return null;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//}
