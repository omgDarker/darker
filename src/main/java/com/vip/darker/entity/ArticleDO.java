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
@TableName(value = "content_article")
@BKDefinition(value = "文章表")
public class ArticleDO extends Model<ArticleDO> {

    private static final long serialVersionUID = 8000144237693925984L;

    @TableId(value = "id", type = IdType.AUTO)
    @BKDefinition(value = "主键ID")
    private Integer id;
    @BKDefinition(value = "标题")
    private String title;
    @BKDefinition(value = "简介")
    private String summary;
    @BKDefinition(value = "内容")
    private String content;
    @BKDefinition(value = "首图名称")
    @TableField(value = "image_name")
    private String imageName;
    @BKDefinition(value = "阅读量")
    @TableField(value = "read_amount")
    private Integer readAmount;
    @BKDefinition(value = "点赞量")
    @TableField(value = "like_amount")
    private Integer likeAmount;
    @BKDefinition(value = "甩鞋量")
    @TableField(value = "like_no_amount")
    private Integer likeNoAmount;
    @BKDefinition(value = "分类ID")
    @TableField(value = "classify_id")
    private Integer classifyId;
    @BKDefinition(value = "栏目ID")
    @TableField(value = "column_id")
    private Integer columnId;
    @BKDefinition(value = "分类名称")
    @TableField(exist = false)
    private String classifyName;
    @BKDefinition(value = "栏目名称")
    @TableField(exist = false)
    private String columnName;
    @BKDefinition(value = "标识:是否删除(增加is会引起RPC框架解析序列化错误)")
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