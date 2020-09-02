//package com.mg.compose.service.repository;
//
//import org.springframework.stereotype.Service;
//import com.mg.compose.pojo.dto.InSysConfigDto;
//import lombok.extern.slf4j.Slf4j;
//import com.mg.compose.pojo.dto.InSysConfigDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.mg.common.pojo.ResultItem;
//import com.mg.compose.service.feign.TokenFeign;
//import java.util.List;
//
//@Service
//@Slf4j
//public class TokenRepository {
//   @Autowired
//   TokenFeign feign;
//
//
//   public ResultItem login(InSysConfigDto item) throws Exception{
//      ResultItem result =  feign.login(item);
//      return result;
//   }
//
//}
