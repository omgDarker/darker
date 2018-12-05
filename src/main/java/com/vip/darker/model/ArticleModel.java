package com.vip.darker.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "content_article")
public class ArticleModel extends Model<ArticleModel> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id; // 唯一标识

    private String title; // 题目

    private String summary; // 简介

    private String content; // 内容

    private String imageName; // 首图名称

    private Integer readAmount; // 阅读量

    private Integer likeAmount; // 喜欢量

    private Integer likeNoAmount; // 不喜欢量

    private Integer classifyId; // 分类ID(生活点滴,技术联盟,个人相册)

    private Integer columnId; // 栏目ID(下拉框选项)

    @TableField(exist = false)
    private String columnName;  // 表示该属性不为数据库表字段,但又是必须使用的

    @TableField(exist = false)
    private String classifyName;  // 表示该属性不为数据库表字段,但又是必须使用的

    private Integer isDelete; // 标识:是否删除

    private String creator; // 创建人名称

    private Date createTime; // 创建时间

    private Date updateTime; // 更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getReadAmount() {
        return readAmount;
    }

    public void setReadAmount(Integer readAmount) {
        this.readAmount = readAmount;
    }

    public Integer getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(Integer likeAmount) {
        this.likeAmount = likeAmount;
    }

    public Integer getLikeNoAmount() {
        return likeNoAmount;
    }

    public void setLikeNoAmount(Integer likeNoAmount) {
        this.likeNoAmount = likeNoAmount;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}