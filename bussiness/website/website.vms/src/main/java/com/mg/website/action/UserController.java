package com.mg.website.action; 

import com.mg.website.common.mapper.GeneralMapper;
import com.mg.website.pojo.vo.UserVo;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.website.service.repository.UserRepository;
import com.mg.website.constant.action.UserControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class UserController {
   @Autowired
   UserRepository repository;
   @Autowired
   GeneralMapper mapper;

   @RequestMapping(UserControllerConstant.ACTION_GET)
   @PreAuthorize("hasAnyAuthority('test')")
   public ResultItem get(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.get(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.edit(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.list(pojo);
   }
   @RequestMapping(UserControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.delete(pojo);
   }

}
