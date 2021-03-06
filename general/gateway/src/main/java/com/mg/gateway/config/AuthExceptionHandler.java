//package com.mg.gateway.config;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Component
//@Slf4j
//public class AuthExceptionHandler extends OAuth2AccessDeniedHandler implements AuthenticationEntryPoint, AuthenticationFailureHandler {
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        demo(httpServletRequest,httpServletResponse,e);
//    }
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//       demo(httpServletRequest,httpServletResponse,e);
//    }
//
//    public void demo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
//        log.info("用户认证失败，禁止访问 {} 失败原因：{}", httpServletRequest.getRequestURI(),e.getMessage());
//        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setContentType("application/json; charset=utf-8");
////        ResultItem<String> result = new ResultItem<>(401,"[用户认证失败，禁止访问]:"+e.getMessage());
////        httpServletResponse.setStatus(HttpStatus.SC_OK);
//        PrintWriter printWriter = httpServletResponse.getWriter();
////        log.info(JSON.toJSON(result).toString());
//        printWriter.append(JSON.toJSON("{}").toString());
//    }
//}
