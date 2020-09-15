package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.constant.feign.SiteFeignConstant;
import com.mg.compose.pojo.dto.InSite;
import com.mg.compose.pojo.dto.OutSite;

@FeignClient(name = SiteFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = SiteFeignFallBackFactory.class)
public interface SiteFeign {

   @RequestMapping(SiteFeignConstant.FEIGN_GET)
    ResultItem<OutSite> get(InSite item);
   @RequestMapping(SiteFeignConstant.FEIGN_EDIT)
    ResultItem<OutSite> edit(InSite item);
   @RequestMapping(SiteFeignConstant.FEIGN_LIST)
    ResultItem<OutSite> list(InSite item);
   @RequestMapping(SiteFeignConstant.FEIGN_DELETE)
    ResultItem<OutSite> delete(InSite item);

}
