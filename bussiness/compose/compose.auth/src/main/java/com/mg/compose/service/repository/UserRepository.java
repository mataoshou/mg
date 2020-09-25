package com.mg.compose.service.repository; 

import com.mg.common.util.ResultItemUtil;
import com.mg.compose.common.mapper.GeneralMapper;
import com.mg.compose.pojo.bo.UserBo;
import lombok.Data;
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
   
   public UserBo getByName(String userName) throws Exception{
      InUserDto dto = new InUserDto();
      dto.setUserName(userName);
      ResultItem<OutUserDto> result =  feign.getByName(dto);
      OutUserDto outUserDto = ResultItemUtil.getDate(result);
      UserBo bo = mapper.convert(outUserDto,UserBo.class);
      return bo;
   }

}
