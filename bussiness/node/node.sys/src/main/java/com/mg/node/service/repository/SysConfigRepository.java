package com.mg.node.service.repository; 

import com.mg.node.dao.SysSiteDAO;
import org.springframework.stereotype.Service;
import com.mg.node.pojo.dto.OutSysConfigDto;
import com.mg.node.pojo.dto.InSysConfigDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.node.db.sql.pojo.MTdSysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.mapper.GeneralMapper;
import com.mg.node.dao.SysConfigDAO;
import com.mg.node.service.feign.SysConfigFeign;
import java.util.List;

@Service
@Slf4j
public class SysConfigRepository {
   @Autowired
   SysConfigDAO dao;

   @Autowired
   SysSiteDAO sysSiteDAO;

   @Autowired
   GeneralMapper mapper;

   
   public ResultItem get(InSysConfigDto item) throws Exception{
      MTdSysConfig pojo = dao.getById(item.getId());
      OutSysConfigDto dto = mapper.convert(pojo,OutSysConfigDto.class);
      mapper.convertor(sysSiteDAO.getById(dto.getId()),dto);
      ResultItem result =  new ResultItem<OutSysConfigDto>(dto);
      return result;
   }
   
   public ResultItem edit(InSysConfigDto item) throws Exception{
      MTdSysConfig pojo = mapper.convert(item,MTdSysConfig.class);
      ResultItem result = new ResultItem<OutSysConfigDto>(mapper.convert(dao.edit(pojo),OutSysConfigDto.class));
      return result;
   }
   
   public ResultItem list(InSysConfigDto item) throws Exception{
      List<MTdSysConfig> list = dao.list();
      ResultItem result =  new ResultItem<OutSysConfigDto>(mapper.convert(list,OutSysConfigDto.class));
      return result;
   }
   
   public ResultItem delete(InSysConfigDto item) throws Exception{
      dao.delete(item.getId());
      ResultItem result = new ResultItem();
      return result;
   }

}
