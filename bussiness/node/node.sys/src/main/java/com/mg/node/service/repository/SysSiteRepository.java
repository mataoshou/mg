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

   public ResultItem get1(Long id) throws Exception{
      MTdSysSite pojo = dao.get(id);
      OutSysSiteDto dto = mapper.convert(pojo,OutSysSiteDto.class);
      ResultItem result =  new ResultItem<OutSysSiteDto>(dto);
      return result;
   }
   
   public ResultItem get(InSysSiteDto item) throws Exception{
      MTdSysSite pojo = dao.get(item.getSiteId());
      OutSysSiteDto dto = mapper.convert(pojo,OutSysSiteDto.class);
      ResultItem result =  new ResultItem<OutSysSiteDto>(dto);
      return result;
   }
   
   public ResultItem insert(InSysSiteDto item) throws Exception{
      MTdSysSite site =mapper.convert(item,MTdSysSite.class);
      dao.edit(site);
      OutSysSiteDto dto = mapper.convert(site,OutSysSiteDto.class);
      ResultItem result =  new ResultItem<OutSysSiteDto>(dto);
      return result;
   }
   
   public ResultItem list(InSysSiteDto item) throws Exception{
      List<MTdSysSite> list = dao.list();
      ResultItem result =  new ResultItem<OutSysSiteDto>(mapper.convert(list,OutSysSiteDto.class));
      return result;
   }
   
   public ResultItem update(InSysSiteDto item) throws Exception{
      return null;
   }
   
   public ResultItem delete(InSysSiteDto item) throws Exception{
      dao.delete(item.getSiteId());
      ResultItem result = new ResultItem();
      return result;
   }
   
   public ResultItem getByName(InSysSiteDto item) throws Exception{
      MTdSysSite pojo = dao.getByName(item.getSiteName());
      OutSysSiteDto dto = mapper.convert(pojo,OutSysSiteDto.class);
      ResultItem result =  new ResultItem<OutSysSiteDto>(dto);
      return result;
   }


}
