package com.mg.node.pojo.dto.in;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import lombok.Data;

import java.util.Date;

@Data
public class InUserDto{

    private String userId;

    private String userCode;

    private String userName;

    private String userPassword;

    private String userDisplayname;

    private String userThumb;

}
