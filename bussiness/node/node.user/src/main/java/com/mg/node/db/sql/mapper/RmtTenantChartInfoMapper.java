package com.mg.node.db.sql.mapper;

import com.mg.node.db.sql.pojo.RmtTenantChartInfo;

public interface RmtTenantChartInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int insert(RmtTenantChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int insertSelective(RmtTenantChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    RmtTenantChartInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int updateByPrimaryKeySelective(RmtTenantChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int updateByPrimaryKey(RmtTenantChartInfo record);
}