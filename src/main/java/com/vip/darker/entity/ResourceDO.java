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
@TableName(value = "resource_content")
@BKDefinition(value = "资源表")
public class ResourceDO extends Model<ResourceDO> {

    private static final long serialVersionUID = 8637447467519786265L;

    @TableId(value = "id", type = IdType.AUTO)
    @BKDefinition(value = "主键ID")
    private Integer id;
    @BKDefinition(value = "编号")
    private Float code;
    @BKDefinition(value = "名称")
    private String name;
    @BKDefinition(value = "路径")
    private String path;
    @BKDefinition(value = "父节点名称")
    @TableField(value = "parent_name")
    private String parentName;
    @BKDefinition(value = "分类名称")
    private String classify;
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

    /**
     * 指定主键
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}