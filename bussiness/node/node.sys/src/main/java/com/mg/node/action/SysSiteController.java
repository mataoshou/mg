package com.mg.node.action; 

import com.mg.node.pojo.dto.InSysSiteDto;
import com.mg.node.pojo.dto.OutSysSiteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.node.service.repository.SysSiteRepository;
import com.mg.node.constant.action.SysSiteControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class SysSiteController {
   @Autowired
   SysSiteRepository repository;

   @RequestMapping(SysSiteControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InSysSiteDto dtoData) throws Exception{
      return repository.get(dtoData);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody InSysSiteDto dtoData) throws Exception{
      return repository.edit(dtoData);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InSysSiteDto dtoData) throws Exception{
      return repository.list(dtoData);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InSysSiteDto dtoData) throws Exception{
      return repository.delete(dtoData);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_GETBYNAME)
   public ResultItem getByName(@RequestBody InSysSiteDto dtoData) throws Exception{
      return repository.getByName(dtoData);
   }


}
