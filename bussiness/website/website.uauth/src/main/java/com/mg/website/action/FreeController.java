package com.mg.website.action; 

import com.mg.website.common.mapper.GeneralMapper;
import com.mg.website.pojo.vo.UserVo;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.website.service.repository.FreeRepository;
import com.mg.website.constant.action.FreeControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class FreeController {
   @Autowired
   FreeRepository repository;
   @Autowired
   GeneralMapper mapper;

   @RequestMapping(FreeControllerConstant.ACTION_LOGIN)
   public ResultItem login(@RequestBody UserVo voData) throws Exception{
      InUserDto pojo = mapper.convert(voData,InUserDto.class);
      return repository.login(pojo);
   }

}
