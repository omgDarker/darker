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
@TableName(value = "content_message")
@BKDefinition(value = "留言表")
public class MessageDO extends Model<MessageDO> {

    private static final long serialVersionUID = -8004450162591054126L;

    @TableId(value = "id", type = IdType.AUTO)
    @BKDefinition(value = "主键ID")
    private Integer id;
    @BKDefinition(value = "用户ID")
    @TableField(value = "user_id")
    private Integer userId;
    @BKDefinition(value = "文章ID")
    @TableField(value = "article_id")
    private Integer articleId;
    @BKDefinition(value = "用户名称")
    @TableField(value = "user_name")
    private String userName;
    @BKDefinition(value = "用户邮箱")
    private String email;
    @BKDefinition(value = "内容")
    private String content;
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