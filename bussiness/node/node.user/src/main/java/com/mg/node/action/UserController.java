package com.mg.node.action; 

import com.mg.node.pojo.dto.InUserDto;
import com.mg.node.pojo.dto.OutUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.node.service.repository.UserRepository;
import com.mg.node.constant.action.UserControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;

@Slf4j
@RestController
public class UserController {
   @Autowired
   UserRepository repository;

   @RequestMapping(UserControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InUserDto dtoData) throws Exception{
      return repository.get(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_INSERT)
   public ResultItem insert(@RequestBody InUserDto dtoData) throws Exception{
      return repository.insert(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InUserDto dtoData) throws Exception{
      return repository.list(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_UPDATE)
   public ResultItem update(@RequestBody InUserDto dtoData) throws Exception{
      return repository.update(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InUserDto dtoData) throws Exception{
      return repository.delete(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_GETBYNAME)
   public ResultItem getByName(@RequestBody InUserDto dtoData) throws Exception{
      return repository.getByName(dtoData);
   }



}
