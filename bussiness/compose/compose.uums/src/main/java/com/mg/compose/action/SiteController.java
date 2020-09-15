package com.mg.compose.action; 

import com.mg.compose.pojo.dto.InSite;
import com.mg.compose.pojo.dto.OutSite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.compose.service.repository.SiteRepository;
import com.mg.compose.constant.action.SiteControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class SiteController {
   @Autowired
   SiteRepository repository;

   @RequestMapping(SiteControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InSite dto) throws Exception{
      return repository.get(dto);
   }
   @RequestMapping(SiteControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody InSite dto) throws Exception{
      return repository.edit(dto);
   }
   @RequestMapping(SiteControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InSite dto) throws Exception{
      return repository.list(dto);
   }
   @RequestMapping(SiteControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InSite dto) throws Exception{
      return repository.delete(dto);
   }

}
