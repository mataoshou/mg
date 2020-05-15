package com.mg.website.uauth.pojo.dto;


import com.mg.website.uauth.pojo.bo.UserBo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDtoTest {


    @Autowired
    DozerBeanMapper dozer;

    @Test
    public void classInit() {
        UserBo userBo = new UserBo();
        userBo.setSid(100);
        userBo.setSname("matao");
        UserDto userDto = dozer.map(userBo, UserDto.class);

        System.out.println(userDto.getId());

    }
}