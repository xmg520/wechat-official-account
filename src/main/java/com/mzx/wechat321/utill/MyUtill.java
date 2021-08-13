package com.mzx.wechat321.utill;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mzx.wechat321.pojo.ReplyMessage;
import com.mzx.wechat321.pojo.UserRqPojo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author Mzx
 */
public class MyUtill {

    // 查询电量工具
    public static String getCont(String search)  throws IOException {
        System.out.println(search);
        JSONObject jsonObject = JSON.parseObject(JsoupUtill.toGet(search));
        String ov = "宿舍号:"+jsonObject.get("description")+"\n剩余电量:"+jsonObject.get("quantity")+"度";
        return ov;
    }

    // 封装用户请求
    public static ReplyMessage getReplyMessage(HttpServletRequest request){
        ReplyMessage replyMessage = new ReplyMessage();
        Map<String, String> map = WechatMessageUtil.xmlToMap(request);

        replyMessage.setMsgType(map.get("MsgType"));
        replyMessage.setFromUserName(map.get("ToUserName"));
        replyMessage.setToUserName(map.get("FromUserName"));
        switch (replyMessage.getMsgType()){
            case WechatMessageUtil.MESSAGE_TEXT:
                System.out.println(map.get("MsgType"));
                String msgcont = map.get("Content").replace(" ","");
                replyMessage.setContent(msgcont);
                break;
            case WechatMessageUtil.MESSAtGE_IMAGE:
                String picurl = map.get("PicUrl");
                System.out.println(picurl);
                replyMessage.setPicUrl(picurl);
                break;
            case WechatMessageUtil.MESSAGE_VOICE:
                System.out.println("vocie");
                break;
            case WechatMessageUtil.MESSAGE_LOCATION:
                System.out.println("坐标");
                break;
            case WechatMessageUtil.MESSAGE_EVENT_SUBSCRIBE:
                System.out.println("订阅");
                break;
            case WechatMessageUtil.MESSAGE_EVENT_UNSUBSCRIBE:
                System.out.println("取消");
                break;
            case WechatMessageUtil.MESSAGE_LINK:
                System.out.println("link");
                break;
        }
        return replyMessage;
    }

}
