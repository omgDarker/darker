package com.vip.darker.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vip.darker.entity.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

public interface UserDao extends BaseMapper<UserDO> {

    /**
     * 功能描述: 用户新增(获取新增数据ID)
     *
     * @param: [UserModel]
     * @return:
     * @auther: darker
     * @date: 2018/7/21 9:42
     */
    @Insert(value = " insert into blog_user (id, name, isDelete, creator, createTime, updateTime)\n"
            + " values " +
            "(#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{isDelete,jdbcType=INTEGER}, #{creator,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}\n")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT)
    boolean add(UserDO userDO);
}