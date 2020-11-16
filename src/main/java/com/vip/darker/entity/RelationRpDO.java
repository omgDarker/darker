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
@TableName(value = "relation_role_permission")
@BKDefinition(value = "角色权限关系表")
public class RelationRpDO extends Model<RelationRpDO> {

    private static final long serialVersionUID = 7207868257509919089L;

    @TableId(value = "id", type = IdType.AUTO)
    @BKDefinition(value = "主键ID")
    private Integer id;
    @BKDefinition(value = "角色ID")
    @TableField(value = "role_id")
    private Integer roleId;
    @BKDefinition(value = "权限ID")
    @TableField(value = "permission_id")
    private Integer permissionId;
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