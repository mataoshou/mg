package com.mg.node.db.sql.mapper;

import com.mg.node.db.sql.pojo.RmtDepartmentExtendInfo;

public interface RmtDepartmentExtendInfoBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int insert(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int insertSelective(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    RmtDepartmentExtendInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKeySelective(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKey(RmtDepartmentExtendInfo record);
}