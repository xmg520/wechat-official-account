package com.mzx.wechat321.controller;


import com.mzx.wechat321.service.MsgService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    MsgService msgService;

    @RequestMapping("/select")
    public Map<String,Object> select(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",msgService.findAll());
        return map;
    }

    @RequestMapping("/selectBykey")
    public Map<String,Object> selectBykey(String key){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",msgService.searchMsgbyKey(key));
        return map;
    }

    @RequestMapping("/deleteById")
    public Map<String,Object> deleteById(String id){
        Map<String,Object> map = new HashMap<>();
        int did = Integer.valueOf(id);
        map.put("code",200);
        map.put("data",msgService.deleteById(did)>=0?"添加数据成功":"删除失败，无法找到信息");
        return map;
    }


}
