package com.vip.darker.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.vip.darker.annotation.BKDefinition;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "resource_content")
@BKDefinition(value = "资源表")
public class ResourceDO extends Model<ResourceDO> implements Serializable {

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
    private String parentName;
    @BKDefinition(value = "分类名称") // 此字段无意义
    private String classify;
    @BKDefinition(value = "标识:是否删除")
    private Integer isDelete;
    @BKDefinition(value = "创建人")
    private String creator;
    @BKDefinition(value = "创建时间")
    private Date createTime;
    @BKDefinition(value = "更新时间")
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