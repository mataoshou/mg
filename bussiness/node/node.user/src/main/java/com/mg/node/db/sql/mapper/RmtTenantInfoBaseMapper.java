package com.mg.node.db.sql.mapper;

import com.mg.node.db.sql.pojo.RmtTenantInfo;

public interface RmtTenantInfoBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int insert(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int insertSelective(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    RmtTenantInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKeySelective(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKey(RmtTenantInfo record);
}