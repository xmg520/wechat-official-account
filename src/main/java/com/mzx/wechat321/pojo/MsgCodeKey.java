package com.mzx.wechat321.pojo;

import java.io.Serializable;

public class MsgCodeKey implements Serializable {
    private Integer id;
    private String create_time;
    private String msg_name;
    private String msg_code;
    private String msg_keyword;
    private String msg_content;
    // 默认添加为0 关闭状态 需要后台开启
    private int msg_isable = 0;

    @Override
    public String toString() {
        return "MsgCodeKey{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", msg_name='" + msg_name + '\'' +
                ", msg_code='" + msg_code + '\'' +
                ", msg_keyword='" + msg_keyword + '\'' +
                ", msg_content='" + msg_content + '\'' +
                ", msg_isable=" + msg_isable +
                '}';
    }

    public int getMsg_isable() {
        return msg_isable;
    }

    public void setMsg_isable(int msg_isable) {
        this.msg_isable = msg_isable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getMsg_name() {
        return msg_name;
    }

    public void setMsg_name(String msg_name) {
        this.msg_name = msg_name;
    }

    public String getMsg_code() {
        return msg_code;
    }

    public void setMsg_code(String msg_code) {
        this.msg_code = msg_code;
    }

    public String getMsg_keyword() {
        return msg_keyword;
    }

    public void setMsg_keyword(String msg_keyword) {
        this.msg_keyword = msg_keyword;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }
}
