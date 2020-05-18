package com.mg.website.pojo.dto;


import com.mg.website.pojo.bo.UserBo;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        InUserDto userDto = new InUserDto();
//        UserDto userDto = dozer.map(userBo, UserDto.class);

        dozer.map(userBo,userDto);
        System.out.println(userDto.getId());

    }
}