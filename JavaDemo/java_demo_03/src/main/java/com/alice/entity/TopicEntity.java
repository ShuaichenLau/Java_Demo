package com.alice.entity;

import java.io.Serializable;

/**
 * @author liusc
 * 2019年6月28日16:56:17
 */
public class TopicEntity implements Serializable {

    private String id; //int(11) NOT NULL AUTO_INCREMENT,
    private String title; //varchar(255) DEFAULT NULL,
    private String content; //varchar(255) DEFAULT NULL,
    private String tag; //varchar(255) DEFAULT NULL,
    private String in_time; //datetime DEFAULT NULL,

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }
}
