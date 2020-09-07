package com.mg.node.service.repository; 

import org.springframework.stereotype.Service;
import com.mg.node.pojo.dto.InUserDto;
import com.mg.node.pojo.dto.InUserDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.node.db.sql.pojo.MTdUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.mapper.GeneralMapper;
import com.mg.node.dao.UserDAO;
import com.mg.node.service.feign.UserFeign;
import java.util.List;

@Service
@Slf4j
public class UserRepository {
   @Autowired
   UserDAO dao;
   @Autowired
   GeneralMapper mapper;

   
   public ResultItem get(InUserDto item) throws Exception{
      MTdUserInfo pojo = dao.get(item.getId());
      InUserDto dto = mapper.convert(pojo,InUserDto.class);
      ResultItem result =  new ResultItem<InUserDto>(dto);
      return result;
   }
   
   public ResultItem edit(InUserDto item) throws Exception{
      MTdUserInfo pojo = mapper.convert(item,MTdUserInfo.class);
      ResultItem result = new ResultItem<InUserDto>(mapper.convert(dao.edit(pojo),InUserDto.class));
      return result;
   }
   
   public ResultItem list(InUserDto item) throws Exception{
      List<MTdUserInfo> list = dao.list();
      ResultItem result =  new ResultItem<InUserDto>(mapper.convert(list,InUserDto.class));
      return result;
   }
   
   public ResultItem delete(InUserDto item) throws Exception{
      dao.delete(item.getId());
      ResultItem result = new ResultItem();
      return result;
   }
   
   public ResultItem getByName(InUserDto item) throws Exception{
      MTdUserInfo pojo = dao.getByName(item.getName());
      InUserDto dto = mapper.convert(pojo,InUserDto.class);
      ResultItem result =  new ResultItem<InUserDto>(dto);
      return result;
   }

}
