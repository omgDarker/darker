package com.vip.darker.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.vip.darker.annotation.BKDefinition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "blog_user")
@BKDefinition(value = "用户表")
public class UserDO extends Model<UserDO> {

    private static final long serialVersionUID = 409196026452916837L;

    @TableId(value = "id", type = IdType.AUTO)
    @BKDefinition(value = "主键ID")
    private Integer id;
    @BKDefinition(value = "名称")
    private String name;
    @BKDefinition(value = "密码:用于后台登录")
    private String password;
    @BKDefinition(value = "邮箱")
    private String email;
    @BKDefinition(value = "地区")
    private String area;
    @BKDefinition(value = "IP")
    private String ip;
    @BKDefinition(value = "记录session")
    @TableField(value = "session_id")
    private String sessionId;
    @BKDefinition(value = "记录用户登录时间")
    @TableField(value = "login_time")
    private String loginTime;
    @BKDefinition(value = "标识:是否删除")
    @TableField(value = "is_deleted")
    private Integer deleted;
    @BKDefinition(value = "创建人")
    private String creator;
    @BKDefinition(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;
    @BKDefinition(value = "更新时间")
    @TableField(value = "update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}