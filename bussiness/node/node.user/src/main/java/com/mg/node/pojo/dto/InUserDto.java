package com.mg.node.pojo.dto;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import lombok.Data;

import java.util.Date;

@Data
public class InUserDto{
    private Long userId;
    private String userName;
    private String userWeixin;
    private String userWeibo;
    private String userQq;
    private String userTelephone;
}
