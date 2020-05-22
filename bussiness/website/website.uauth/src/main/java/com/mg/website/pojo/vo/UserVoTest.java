package com.mg.website.pojo.vo;

import com.mg.website.pojo.dto.InUserDto;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;

class UserVoTest {

//    @Test
    public static void main(String[] args) {
        Mapper dozerMapper = new DozerBeanMapper();

        UserVo userVo = new UserVo();
        userVo.setSname("mg");
        userVo.setSid(10);

        InUserDto userDto = dozerMapper.map(userVo,InUserDto.class);
        System.out.println(userDto.getName());
    }
}