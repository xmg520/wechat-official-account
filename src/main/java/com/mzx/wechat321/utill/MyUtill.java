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
        replyMessage.setContent(map.get("Content"));
        replyMessage.setFromUserName(map.get("FromUserName"));
        replyMessage.setMsgType(map.get("MsgType"));
        replyMessage.setToUserName(map.get("ToUserName"));
        return replyMessage;
    }

}
