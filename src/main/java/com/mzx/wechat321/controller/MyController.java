package com.mzx.wechat321.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mzx.wechat321.pojo.MsgCodeKey;
import com.mzx.wechat321.pojo.Teml;
import com.mzx.wechat321.pojo.ReplyMessage;
import com.mzx.wechat321.pojo.UserRqPojo;
import com.mzx.wechat321.service.MsgService;
import com.mzx.wechat321.utill.JsoupUtill;
import com.mzx.wechat321.utill.WechatMessageUtil;
import com.mzx.wechat321.utill.MyUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mzx.wechat321.utill.ByteToUtill.byteToStr;

@Controller
public class MyController {

    // 与接口配置信息中的Token要一致
    private static String token = "mzxtoken";

    @Autowired
    MsgService msgService;

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
    public String getToken(HttpServletRequest request) throws IOException {
        ReplyMessage replyMessage = MyUtill.getReplyMessage(request);
        String msg = "";
        // 回复内容
        String responseMessage = "success";
        replyMessage.setCreateTime(System.currentTimeMillis());
        System.out.println(replyMessage);
        // 对消息进行处理
        try{
            switch (replyMessage.getMsgType()){
                case WechatMessageUtil.MESSAGE_TEXT:
                    if (Character.isDigit(replyMessage.getContent().charAt(0))){
                        if (replyMessage.getContent().length()>3 && !replyMessage.getContent().contains("http")){
                            msg = "感谢使用，本次查询结果为：\n"+msgService.searchMsgbyCode(replyMessage.getContent()).getMsg_content();
                        }else {
                            if (replyMessage.getContent().contains("http")){
                                throw new NullPointerException("无内容报错返回");
                            }
                            msg = MyUtill.getCont(replyMessage.getContent());
                        }
                    }else {
                        // 关键字查询暂缓
                        List<MsgCodeKey> msgcok = msgService.searchMsgbyKey(replyMessage.getContent());
                        for (MsgCodeKey m:msgcok){
                            System.out.println(m);
                            msg = m.getMsg_content() + "\n";
                        }
                        if (replyMessage.getContent().contains("http") || msgcok.size() < 1){
                            throw new NullPointerException("无内容报错返回");
                        }
                    }

                    replyMessage.setContent(msg);
                    responseMessage = WechatMessageUtil.textMessageToXml(replyMessage).replace(" ","");
                    break;
                case WechatMessageUtil.MESSAtGE_IMAGE:
                    if(replyMessage.getCreateTime()!=0){
                        throw new NullPointerException("无内容报错返回");
                    }
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
        }catch (Exception e){
            replyMessage.setContent("本次请求异常，请检查数据重新尝试");
            responseMessage = WechatMessageUtil.textMessageToXml(replyMessage);
        }


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
