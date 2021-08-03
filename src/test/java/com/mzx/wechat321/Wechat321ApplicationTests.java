package com.mzx.wechat321;

import com.github.pagehelper.PageHelper;
import com.mzx.wechat321.pojo.MsgCodeKey;
import com.mzx.wechat321.pojo.ReplyMessage;
import com.mzx.wechat321.service.MsgService;
import com.mzx.wechat321.utill.WechatMessageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Wechat321ApplicationTests {

    @Autowired
    MsgService msgService;

    @Test
    void contextLoads() {
        MsgCodeKey msgCodeKey = msgService.searchMsgbyCode("11");
        System.out.println(msgCodeKey);
//        List<MsgCodeKey> list = msgService.searchMsgbyKey("个人");
//        list.stream().forEach(System.out::println);
//        PageHelper.startPage(2,4);
//        System.out.println(6/4);
//        List<MsgCodeKey> msgCodeKeyList = msgService.findAll();
//        msgCodeKeyList.forEach(System.out::println);
    }

    @Test
    void T1() {
        System.out.println("123".length());
        System.out.println("123456".length());
        ReplyMessage replyMessage = new ReplyMessage();
        replyMessage.setMsgType("text");
        String responseMessage = "";
        switch (replyMessage.getMsgType()){
            case WechatMessageUtil.MESSAGE_TEXT:
                System.out.println(1);
                break;
            case WechatMessageUtil.MESSAtGE_IMAGE:
                System.out.println(2);
                break;
            case WechatMessageUtil.MESSAGE_VOICE:
                System.out.println(3);
                break;
            case WechatMessageUtil.MESSAGE_LOCATION:
                System.out.println(4);
                break;
            case WechatMessageUtil.MESSAGE_EVENT_SUBSCRIBE:
                System.out.println(5);
                break;
            case WechatMessageUtil.MESSAGE_EVENT_UNSUBSCRIBE:
                System.out.println(6);
                break;
        }
        MsgCodeKey m = new MsgCodeKey();
        System.out.println(m);
        m.setMsg_isable(1);
        System.out.println(m);
    }

}
