package com.mg.node.pojo.dto.out;

import lombok.Data;

import java.util.Date;
@Data
public class OutDepartmentDto {

    private String departmentId;

    private String departmentCode;

    private String departmentName;

    private String departmentType;

    private String description;

    private Date createdtime;

    private String creatorId;

    private Date timeModify;

    private String modifiesId;

}
