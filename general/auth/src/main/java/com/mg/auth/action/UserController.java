//package com.mg.auth.action;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.security.Principal;
//import java.util.Base64;
//
//@RestController
//@RequestMapping("/user")
//@Slf4j
//public class UserController {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @RequestMapping(value = "/get", method = RequestMethod.POST)
//    public Principal getUser(String  username,String  password) {
//        MultiValueMap formData = new LinkedMultiValueMap();
//        formData.add("grant_type", "password");
//        formData.add("username", username);
//        formData.add("password", password);
//
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString(new String("shineon:shineon").getBytes()));
//        HttpEntity<MultiValueMap> requestentity = new HttpEntity<MultiValueMap>(formData, headers);
//
//        return null;
//    }
//}
