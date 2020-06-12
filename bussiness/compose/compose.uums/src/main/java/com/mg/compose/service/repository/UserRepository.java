package com.mg.compose.service.repository; 

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import com.mg.compose.pojo.dto.InUserDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.compose.pojo.dto.OutUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.service.feign.UserFeign;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserRepository {
   @Autowired
   UserFeign feign;

//   @LcnTransaction//分布式事务
//   @Transactional //本地事务
//   public ResultItem get1(InUserDto item) throws Exception{
//      ResultItem result =  feign.get(item);
//      ResultItem resultItem = feign.edit(item);
//      return result;
//   }

   public ResultItem get(InUserDto item) throws Exception{
      ResultItem result =  feign.get(item);
      return result;
   }
   
   public ResultItem edit(InUserDto item) throws Exception{
      ResultItem result =  feign.edit(item);
      return result;
   }
   
   public ResultItem list(InUserDto item) throws Exception{
      ResultItem result =  feign.list(item);
      return result;
   }
   
   public ResultItem delete(InUserDto item) throws Exception{
      ResultItem result =  feign.delete(item);
      return result;
   }

}
