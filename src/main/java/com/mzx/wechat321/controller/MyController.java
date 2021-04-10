package com.mzx.wechat321.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mzx.wechat321.pojo.Teml;
import com.mzx.wechat321.pojo.TextMessage;
import com.mzx.wechat321.utill.JsoupUtill;
import com.mzx.wechat321.utill.WechatMessageUtil;
import com.mzx.wechat321.utill.unutill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.mzx.wechat321.utill.byteToUtill.byteToStr;

@Controller
public class MyController {

    // 与接口配置信息中的Token要一致
    private static String token = "mzxtoken";

    @RequestMapping(value = "/getCont",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getCont(String search)  throws IOException {
        System.out.println(search);
        JSONObject jsonObject = JSON.parseObject(JsoupUtill.toGet(search));
        Object temls = JSON.parseObject(jsonObject.toJSONString(),Teml.class);
        System.out.println(temls);
        return JsoupUtill.toGet(search);
    }

    @RequestMapping(value = "/getToken",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getToken(HttpServletRequest request) throws IOException, ServletException {
        Map<String, String> map = WechatMessageUtil.xmlToMap(request);
//        System.out.println(map);
        String Content = map.get("Content");
        // 发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        // 消息类型
        String msgType = map.get("MsgType");
        // 默认回复一个"success"
        String responseMessage = "success";
        String msg = unutill.getCont(Content);
        // 对消息进行处理
        if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setContent(msg);
            responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        }
//        System.out.println(Content);
//        System.out.println(responseMessage);
        return responseMessage;
    }


    /**
     * token认证
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/getToken1",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getToken1(String signature, String timestamp,String nonce,String echostr){
        // 1.将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);

        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 3.将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        if (tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false){
            System.out.println(echostr);
            return echostr;
        }else {
            System.out.println("失败了");
            return "";
        }

    }

}
