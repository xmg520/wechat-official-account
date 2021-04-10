package com.mzx.wechat321.utill;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mzx.wechat321.pojo.Teml;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsoupUtill {

//    private static Map<String, String> cookies = null;

    public static void main(String[] args) throws IOException {
        // 先模拟登录获取到cookie和sessionid并存到全局变量cookies中
        String keyCont = "321";
        JSONObject jsonObject = JSON.parseObject(toGet(keyCont));
//        for(int i = 0 ; i < jsonObject.size();i++){
//            System.out.println(jsonObject.getJSONObject(i));
//        }
        System.out.println("宿舍号:"+jsonObject.get("description")+" ===>剩余电量:"+jsonObject.get("quantity")+"度");
//        List<Teml> Temls = JSON.parseArray(jsonObject.toJSONString(),Teml.class);
//        System.out.println(Temls.get(0).getDescription());
    }

    public static String toGet(String keyCont)throws IOException {
        String get_url = "http://h5cloud.17wanxiao.com:8080/CloudPayment/user/getRoomState.do?payProId=1505&schoolcode=2453&businesstype=2&roomverify=3-2--73-" + keyCont;
        Connection connection = Jsoup.connect(get_url);

        connection.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connection.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        connection.header("Content-Length", "72").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connection.header("Host", "h5cloud.17wanxiao.com:8080").header("Referer", "http://h5cloud.17wanxiao.com:8080/CloudPayment/user/getRoomState.do?payProId=1505&schoolcode=2453&businesstype=2&roomverify=3-2--73-");
        connection.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        Response response = connection.ignoreContentType(true).method(Method.GET).execute();
        return response.body();
    }

}
