package com.mg.compose.service.repository; 

import com.mg.common.util.ResultItemUtil;
import com.mg.compose.common.mapper.GeneralMapper;
import com.mg.compose.pojo.bo.UserBo;
import org.springframework.stereotype.Service;
import com.mg.compose.pojo.dto.InUserDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.compose.pojo.dto.OutUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.service.feign.UserFeign;
import java.util.List;

@Service
@Slf4j
public class UserRepository {
   @Autowired
   UserFeign feign;

   @Autowired
   GeneralMapper mapper;
   
   public UserBo getByName(String name) throws Exception{
      InUserDto indto = new InUserDto();
      indto.setName(name);
      ResultItem<OutUserDto> result =  feign.getByName(indto);
      OutUserDto user  = ResultItemUtil.getDate(result);
      UserBo bo = mapper.convert(user,UserBo.class);
      return bo;
   }

}
