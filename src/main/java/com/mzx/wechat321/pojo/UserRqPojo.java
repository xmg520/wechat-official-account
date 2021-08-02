package com.mzx.wechat321.pojo;

public class UserRqPojo {
    private String Content;
    // 发送方帐号（一个OpenID）
    private String fromUserName;
    // 开发者微信号
    private String toUserName;
    // 消息类型
    private String msgType;
    // 默认回复一个"success"
    private String responseMessage = "success";

    public UserRqPojo() {
    }

    public UserRqPojo(String content, String fromUserName, String toUserName, String msgType, String responseMessage) {
        Content = content;
        this.fromUserName = fromUserName;
        this.toUserName = toUserName;
        this.msgType = msgType;
        this.responseMessage = responseMessage;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
