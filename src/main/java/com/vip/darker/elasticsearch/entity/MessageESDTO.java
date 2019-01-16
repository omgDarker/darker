package com.vip.darker.elasticsearch.entity;


import com.vip.darker.annotation.BKDefinition;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "darker", type = "message", shards = 1, replicas = 0)
public class MessageESDTO implements Serializable {

    private static final long serialVersionUID = 3322035763899325878L;

    @Id
    @BKDefinition(value = "文档ID")
    private Integer id;
    @BKDefinition(value = "留言者")
    private String username;
    @BKDefinition(value = "留言内容")
    private String content;

    public MessageESDTO(Integer id, String username, String content) {
        this.id = id;
        this.username = username;
        this.content = content;
    }

    public MessageESDTO(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public MessageESDTO(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}