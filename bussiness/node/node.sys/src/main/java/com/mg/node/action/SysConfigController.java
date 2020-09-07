package com.mg.node.action; 

import com.mg.node.pojo.dto.InSysConfigDto;
import com.mg.node.pojo.dto.OutSysConfigDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.node.service.repository.SysConfigRepository;
import com.mg.node.constant.action.SysConfigControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class SysConfigController {
   @Autowired
   SysConfigRepository repository;

   @RequestMapping(SysConfigControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InSysConfigDto dtoData) throws Exception{
      return repository.get(dtoData);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_INSERT)
   public ResultItem insert(@RequestBody InSysConfigDto dtoData) throws Exception{
      return repository.insert(dtoData);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InSysConfigDto dtoData) throws Exception{
      return repository.list(dtoData);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_UPDATE)
   public ResultItem update(@RequestBody InSysConfigDto dtoData) throws Exception{
      return repository.update(dtoData);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InSysConfigDto dtoData) throws Exception{
      return repository.delete(dtoData);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_GETBYNAME)
   public ResultItem getByName(@RequestBody InSysConfigDto dtoData) throws Exception{
      return repository.getByName(dtoData);
   }

}
