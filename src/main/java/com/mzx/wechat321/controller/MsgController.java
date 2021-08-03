package com.mzx.wechat321.controller;


import com.mzx.wechat321.common.ResponseCommon;
import com.mzx.wechat321.pojo.MsgCodeKey;
import com.mzx.wechat321.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    MsgService msgService;


    @RequestMapping("/select")
    public ResponseCommon select(@RequestParam(value = "msgCodeKey", required = false) MsgCodeKey msgCodeKey,
                                 @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        ResponseCommon responseCommon = new ResponseCommon();
        responseCommon.setCode(200);
        responseCommon.setMsg("success");
        responseCommon.setPageNo(pageNo);
        responseCommon.setPageSize(pageSize);
        List<MsgCodeKey> msgCodeKeys =  msgService.queryUserListPaged(msgCodeKey,pageNo,pageSize);
        int allcount = msgService.findAllCount();
        responseCommon.setTotalCount(allcount);
        responseCommon.setTotalPage((int)Math.ceil(allcount/pageSize)>0?(int)Math.ceil(allcount/pageSize)+1:1);
        responseCommon.setData(msgCodeKeys);
        return responseCommon;
    }


    @RequestMapping("/selectByCode")
    public ResponseCommon selectByCode(int msg_code){
        ResponseCommon responseCommon = new ResponseCommon();
//        responseCommon.setCode(200);
//        responseCommon.setMsg("success");
//        responseCommon.setPageNo(pageNo);
//        responseCommon.setPageSize(pageSize);
//        List<MsgCodeKey> msgCodeKeys =  msgService.queryUserListPaged(pageNo,pageSize);
//        int allcount = msgService.findAllCount();
//        responseCommon.setTotalCount(allcount);
//        responseCommon.setTotalPage((int)Math.ceil(allcount/pageSize)>0?(int)Math.ceil(allcount/pageSize)+1:1);
//        responseCommon.setData(msgCodeKeys);
        return responseCommon;

    }

    @RequestMapping("/deleteById")
    public Map<String,Object> deleteById(String id){
        Map<String,Object> map = new HashMap<>();
        int did = Integer.valueOf(id);
        map.put("code",200);
        map.put("data",msgService.deleteById(did)>=0?"添加数据成功":"删除失败，无法找到信息");
        return map;
    }

    @RequestMapping("/saveByMsg")
    public ResponseCommon saveByMsg(MsgCodeKey msgCodeKey){
        ResponseCommon responseCommon = new ResponseCommon();
        MsgCodeKey findmsg = msgService.searchMsgbyCode(msgCodeKey.getMsg_code());
        if (findmsg!=null){
            msgService.updateAbleByMsg(msgCodeKey);
            responseCommon.setMsg("修改成功");
        }else {
            msgService.addByMsg(msgCodeKey);
            responseCommon.setMsg("添加成功");
        }
        responseCommon.setCode(200);
        return responseCommon;
    }

}
