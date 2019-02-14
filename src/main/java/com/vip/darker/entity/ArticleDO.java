package com.vip.darker.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.vip.darker.annotation.BKDefinition;

import java.io.Serializable;
import java.util.Date;

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

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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

    @Override
    public String toString() {
        super.toString();
        return "ArticleDO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", imageName='" + imageName + '\'' +
                ", readAmount=" + readAmount +
                ", likeAmount=" + likeAmount +
                ", likeNoAmount=" + likeNoAmount +
                ", classifyId=" + classifyId +
                ", columnId=" + columnId +
                ", classifyName='" + classifyName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", deleted=" + deleted +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}