package com.mg.website.action; 

import com.mg.website.common.util.HttpUtil;
import com.mg.website.pojo.vo.UserVo;
import com.mg.website.pojo.dto.OutUserDto;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.vo.OauthVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.website.service.repository.UserRepository;
import com.mg.website.constant.action.UserControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;
import com.mg.website.common.mapper.GeneralMapper;

import javax.annotation.security.RolesAllowed;

@Slf4j
@RestController
public class UserController {
   @Autowired
   UserRepository repository;
   @Autowired
   GeneralMapper mapper;

   @Autowired
   HttpUtil util;

   @RequestMapping(UserControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody UserVo voData) throws Exception{

//      log.info( util.doGet("https://www.baidu.com/",null));

      OutUserDto pojo = mapper.convert(voData,OutUserDto.class);
      return repository.get(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody UserVo voData) throws Exception{
      OutUserDto pojo = mapper.convert(voData,OutUserDto.class);
      return repository.edit(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody UserVo voData) throws Exception{
      OutUserDto pojo = mapper.convert(voData,OutUserDto.class);
      return repository.list(pojo);
   }

   @PreAuthorize("#voData.getUserId().intValue()== 10001 and hasAuthority('ADMIN'.concat(#voData.getGroupId().toString()))")
   @RequestMapping(UserControllerConstant.ACTION_DELETE)
//   @RolesAllowed("matao")
   public ResultItem delete(@RequestBody UserVo voData) throws Exception{
      Object users = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      OutUserDto pojo = mapper.convert(voData,OutUserDto.class);
      return repository.delete(pojo);
   }

}
