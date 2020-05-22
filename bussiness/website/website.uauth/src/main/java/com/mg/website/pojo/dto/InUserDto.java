package com.mg.website.pojo.dto;

import lombok.Data;
import org.dozer.Mapping;

@Data
public class InUserDto {

    @Mapping("sname")
    private String name;
    @Mapping("sid")
    private int id;
}
