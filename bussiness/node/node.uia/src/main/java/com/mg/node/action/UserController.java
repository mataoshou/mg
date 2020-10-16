package com.mg.node.action; 

import com.mg.node.common.plugin.param.annotation.ParamsCheck;
import com.mg.node.pojo.dto.in.InUserDto;
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
   @RequestMapping(UserControllerConstant.ACTION_EDIT)
   @ParamsCheck({
           "userCode:noNull:用户编号不能为空",
           "userPassword:noNull:用户密码不能为空",
           "userDisplayname:noNull:用户显示名称不能为空",
           "userName:noNull:用户名称不能为空"
   })
   public ResultItem edit(@RequestBody InUserDto dtoData) throws Exception{
      return repository.edit(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InUserDto dtoData) throws Exception{
      return repository.list(dtoData);
   }
   @RequestMapping(UserControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InUserDto dtoData) throws Exception{
      return repository.delete(dtoData);
   }

}
