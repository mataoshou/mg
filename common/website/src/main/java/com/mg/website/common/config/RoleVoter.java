//package com.mg.website.common.config;
//
//import org.springframework.security.access.AccessDecisionVoter;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.FilterInvocation;
//
//import java.util.Collection;
//
//public class RoleVoter implements AccessDecisionVoter {
//    @Override
//    public boolean supports(ConfigAttribute configAttribute) {
//        return true;
//    }
//
//    @Override
//    public int vote(Authentication authentication, Object object, Collection collection) {
//        if(authentication == null) {
//            return ACCESS_DENIED;
//        }
//        int result = ACCESS_ABSTAIN;
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        FilterInvocation fi = (FilterInvocation) object;
//        String url = fi.getRequestUrl();
//
//        for (Object co : collection) {
//
//            ConfigAttribute attribute = (ConfigAttribute) co;
//            if(attribute.getAttribute()==null){
//                continue;
//            }
//            if (this.supports(attribute)) {
//                result = ACCESS_DENIED;
//
//                // Attempt to find a matching granted authority
//                for (GrantedAuthority authority : authorities) {
//                    if (attribute.getAttribute().equals(authority.getAuthority())) {
//                        return ACCESS_GRANTED;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
//
//    @Override
//    public boolean supports(Class aClass) {
//        return true;
//    }
//}
