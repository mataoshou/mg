package com.mg.node.pojo.dto.out;

import lombok.Data;

import java.util.Date;

@Data
public class OutUserDto {

    private String userId;

    private String userCode;

    private String userName;

    private String userPassword;

    private String userDisplayname;

    private String userThumb;

    private String userWorkcode;

    private String userOganizationId;

    private String userDepartmentId;

    private String userExtendId;

    private Date timeCreated;

    private String createId;

    private Date timeModify;

    private String modifiesId;
}
