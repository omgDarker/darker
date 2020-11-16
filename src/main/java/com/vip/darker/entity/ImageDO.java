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
@TableName(value = "content_image")
@BKDefinition(value = "图片表")
public class ImageDO extends Model<ImageDO> {

    private static final long serialVersionUID = 4295588827981208475L;

    @TableId(value = "id", type = IdType.AUTO)
    @BKDefinition(value = "主键ID")
    private Integer id;
    @BKDefinition(value = "标题")
    private String title;
    @BKDefinition(value = "描述")
    private String description;
    @BKDefinition(value = "名称")
    private String name;
    @BKDefinition(value = "阅读量")
    @TableField(value = "read_amount")
    private Integer readAmount;
    @BKDefinition(value = "点赞量")
    @TableField(value = "like_amount")
    private Integer likeAmount;
    @BKDefinition(value = "分类ID")
    @TableField(value = "classify_id")
    private Integer classifyId;
    @BKDefinition(value = "栏目ID")
    @TableField(value = "column_id")
    private Integer columnId;
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