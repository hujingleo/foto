package io.renren.modules.generator.controller;


import com.alibaba.fastjson.JSONObject;
import io.renren.modules.generator.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        String url = "http://120.79.227.108:8083/userData/updateUserData";
        //直接调用的GET ,不需要header
        String result = HttpClientUtil.getGetResponse(url);
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NTk1MzI0NTksInVzZXJuYW1lIjoiMTMzOTA2OTI4MkBxcS5jb20ifQ.FwR7fQtB7pUUFOE_j1HepN8Wsl-6JoYVsEDDTfOuSps";
        //直接调用的GET,需要header
        Map<String , String> headerMap = new HashMap<>();
        headerMap.put("token",token);
        String result2 = HttpClientUtil.getGetResponse(url,headerMap);
        System.out.println(result);
        System.out.println(result2);
    }
}
//        Calendar calendar = Calendar.getInstance();

//        Date date = new Date();
//        SimpleDateFormat test = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
//
//        System.out.println(test.format(date));
//        System.out.println(date);
//        System.out.println(calendar);


