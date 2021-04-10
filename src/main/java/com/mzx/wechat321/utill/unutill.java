package com.mzx.wechat321.utill;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mzx.wechat321.pojo.Teml;

import java.io.IOException;

/**
 * @author Mzx
 */
public class unutill {
    public static String getCont(String search)  throws IOException {
        System.out.println(search);
        JSONObject jsonObject = JSON.parseObject(JsoupUtill.toGet(search));
        String ov = "宿舍号:"+jsonObject.get("description")+"\n剩余电量:"+jsonObject.get("quantity")+"度";
        return ov;
    }
}
