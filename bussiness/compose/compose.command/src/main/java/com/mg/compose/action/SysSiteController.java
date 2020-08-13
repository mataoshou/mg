package com.mg.compose.action; 

import com.mg.compose.pojo.dto.InSysSiteDto;
import com.mg.compose.pojo.dto.OutSysSiteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.compose.service.repository.SysSiteRepository;
import com.mg.compose.constant.action.SysSiteControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class SysSiteController {
   @Autowired
   SysSiteRepository repository;

   @RequestMapping(SysSiteControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InSysSiteDto dto) throws Exception{
      return repository.get(dto);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody InSysSiteDto dto) throws Exception{
      return repository.edit(dto);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InSysSiteDto dto) throws Exception{
      return repository.list(dto);
   }
   @RequestMapping(SysSiteControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InSysSiteDto dto) throws Exception{
      return repository.delete(dto);
   }

}
