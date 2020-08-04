package com.mg.node.service.repository; 

import org.springframework.stereotype.Service;
import com.mg.node.pojo.dto.OutSysSiteDto;
import com.mg.node.pojo.dto.InSysSiteDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.node.db.sql.pojo.MTdSysSite;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.mapper.GeneralMapper;
import com.mg.node.dao.SysSiteDAO;
import com.mg.node.service.feign.SysSiteFeign;
import java.util.List;

@Service
@Slf4j
public class SysSiteRepository {
   @Autowired
   SysSiteDAO dao;
   @Autowired
   GeneralMapper mapper;

   
   public ResultItem get(InSysSiteDto item) throws Exception{
      MTdSysSite pojo = dao.getById(item.getId());
      OutSysSiteDto dto = mapper.convert(pojo,OutSysSiteDto.class);
      ResultItem result =  new ResultItem<OutSysSiteDto>(dto);
      return result;
   }
   
   public ResultItem edit(InSysSiteDto item) throws Exception{
      MTdSysSite pojo = mapper.convert(item,MTdSysSite.class);
      ResultItem result = new ResultItem<OutSysSiteDto>(mapper.convert(dao.edit(pojo),OutSysSiteDto.class));
      return result;
   }
   
   public ResultItem list(InSysSiteDto item) throws Exception{
      List<MTdSysSite> list = dao.list();
      ResultItem result =  new ResultItem<OutSysSiteDto>(mapper.convert(list,OutSysSiteDto.class));
      return result;
   }
   
   public ResultItem delete(InSysSiteDto item) throws Exception{
      dao.delete(item.getId());
      ResultItem result = new ResultItem();
      return result;
   }

}
