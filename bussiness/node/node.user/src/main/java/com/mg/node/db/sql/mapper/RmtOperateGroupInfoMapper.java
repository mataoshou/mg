package com.mg.node.db.sql.mapper;

import com.mg.node.db.sql.pojo.RmtOperateGroupInfo;

public interface RmtOperateGroupInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int insert(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int insertSelective(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    RmtOperateGroupInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int updateByPrimaryKeySelective(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Thu Jul 09 17:07:45 CST 2020
     */
    int updateByPrimaryKey(RmtOperateGroupInfo record);
}