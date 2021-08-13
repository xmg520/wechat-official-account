package com.mzx.wechat321.pojo;

public class ReplyMessage {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/image/location/link）
    private String MsgType;
    // 消息id，64位整型
    private long MsgId;
    /**
     * 位0x0001被标志时，星标刚收到的消息
     */
    private int FuncFlag;

    // 文本消息内容
    private String Content;
    // 图片回复部分
    // 图片url
    private String PicUrl;
    // MediaId 图片消息媒体id，可以调用获取临时素材接口拉取数据。
    private  long MediaId = 1;

    // 链接消息
    private String Title = "title";
    private String Description = "contents";

    private String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public long getMediaId() {
        return MediaId;
    }

    public void setMediaId(long mediaId) {
        MediaId = mediaId;
    }

    public String getToUserName() {
        return ToUserName;
    }
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }
    public String getFromUserName() {
        return FromUserName;
    }
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
    public long getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(long l) {
        CreateTime = l;
    }
    public String getMsgType() {
        return MsgType;
    }
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }
    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public int getFuncFlag() {
        return FuncFlag;
    }

    public void setFuncFlag(int funcFlag) {
        FuncFlag = funcFlag;
    }

    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }


    @Override
    public String toString() {
        return "ReplyMessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", MsgId=" + MsgId +
                ", FuncFlag=" + FuncFlag +
                ", Content='" + Content + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                ", MediaId=" + MediaId +
                '}';
    }
}
