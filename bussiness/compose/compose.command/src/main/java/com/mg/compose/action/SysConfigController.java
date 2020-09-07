package com.mg.compose.action; 

import com.mg.compose.pojo.dto.InSysConfigDto;
import com.mg.compose.pojo.dto.OutSysConfigDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.compose.service.repository.SysConfigRepository;
import com.mg.compose.constant.action.SysConfigControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class SysConfigController {
   @Autowired
   SysConfigRepository repository;

   @RequestMapping(SysConfigControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InSysConfigDto dto) throws Exception{
      return repository.get(dto);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody InSysConfigDto dto) throws Exception{
      return repository.edit(dto);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InSysConfigDto dto) throws Exception{
      return repository.list(dto);
   }
   @RequestMapping(SysConfigControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InSysConfigDto dto) throws Exception{
      return repository.delete(dto);
   }

}
