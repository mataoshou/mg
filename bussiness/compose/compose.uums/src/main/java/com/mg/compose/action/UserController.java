package com.mg.compose.action; 

import com.mg.compose.pojo.dto.InUserDto;
import com.mg.compose.pojo.dto.OutUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.compose.service.repository.UserRepository;
import com.mg.compose.constant.action.UserControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class UserController {
   @Autowired
   UserRepository repository;

   @RequestMapping(UserControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InUserDto dto) throws Exception{
      return repository.get(dto);
   }
   @RequestMapping(UserControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody InUserDto dto) throws Exception{
      return repository.edit(dto);
   }
   @RequestMapping(UserControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InUserDto dto) throws Exception{
      return repository.list(dto);
   }
   @RequestMapping(UserControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InUserDto dto) throws Exception{
      return repository.delete(dto);
   }

}
