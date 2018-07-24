package com.vip.darker.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "blog_resource")
public class ResourceModel extends Model<ResourceModel> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Float code;

    private String name;

    private String path;

    private String parentName;

    private String classify;

    private Integer isDelete;

    private String creator;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCode() {
        return code;
    }

    public void setCode(Float code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        if (isDelete != null) {
            this.isDelete = isDelete;
        } else {
            this.isDelete = 0;
        }
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (StringUtils.isNotBlank(creator)) {
            this.creator = creator;
        } else {
            this.creator = "darker";
        }

    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        if (createTime != null) {
            this.createTime = createTime;
        } else {
            this.createTime = new Date();
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    // 指定主键
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}