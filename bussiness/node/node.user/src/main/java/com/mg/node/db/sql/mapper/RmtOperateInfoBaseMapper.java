package com.mg.node.db.sql.mapper;

import com.mg.node.db.sql.pojo.RmtOperateInfo;

public interface RmtOperateInfoBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int insert(RmtOperateInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int insertSelective(RmtOperateInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    RmtOperateInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKeySelective(RmtOperateInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Wed May 20 15:46:04 CST 2020
     */
    int updateByPrimaryKey(RmtOperateInfo record);
}