package com.mzx.wechat321.controller;


import com.mzx.wechat321.common.ResponseCommon;
import com.mzx.wechat321.pojo.MsgCodeKey;
import com.mzx.wechat321.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    MsgService msgService;


    @RequestMapping("/select")
    public ResponseCommon select(@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                 @RequestParam(value = "msg_name", required = false, defaultValue = "") String msg_name,
                                 @RequestParam(value = "msg_code", required = false, defaultValue = "") String msg_code,
                                 @RequestParam(value = "status", required = false, defaultValue = "2") int status,
                                 @RequestParam(value = "date", required = false, defaultValue = "") String date
    ){
        int allcount = msgService.findAllCount();
        MsgCodeKey msgCodeKey = new MsgCodeKey(date,msg_name,msg_code,status);
        List<MsgCodeKey> msgCodeKeys =  msgService.queryUserListPaged(msgCodeKey,pageNo,pageSize);
        ResponseCommon responseCommon = new ResponseCommon(pageNo,pageSize,200,"success",
                (int)Math.ceil(allcount/pageSize)>0?(int)Math.ceil(allcount/pageSize)+1:1,
                allcount,msgCodeKeys

        );
        return responseCommon;
    }


    @RequestMapping("/deleteById")
    public ResponseCommon deleteById(@RequestParam String id){
        ResponseCommon responseCommon = new ResponseCommon();
        int did = Integer.valueOf(id);
        responseCommon.setCode(200);
        responseCommon.setMsg(msgService.deleteById(did)>=0?"添加数据成功":"删除失败，无法找到信息");
        return responseCommon;
    }

    @PostMapping("/saveByMsg")
    public ResponseCommon saveByMsg(@RequestBody MsgCodeKey msgCodeKey){
        ResponseCommon responseCommon = new ResponseCommon();
        // 处理前端时间格式
        LocalDateTime localDateTime = LocalDateTime.now();
        String lctime = localDateTime.toString().substring(0,localDateTime.toString().length()-7).replace("T"," ");
        msgCodeKey.setCreate_time(lctime);

        // 当id为0为添加接口 其他均为修改接口
        if (msgCodeKey.getId() == 0){
            // 去除id 让数据库自增数据
            msgCodeKey.setId(null);
            msgService.addByMsg(msgCodeKey);
            responseCommon.setMsg("添加成功");
        }else {
            msgService.updateByMsg(msgCodeKey);
            responseCommon.setMsg("修改成功");
        }
        responseCommon.setCode(200);
        return responseCommon;
    }

}
