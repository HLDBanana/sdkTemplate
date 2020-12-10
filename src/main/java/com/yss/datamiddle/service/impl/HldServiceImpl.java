package com.yss.datamiddle.service.impl;

import com.yss.datamiddle.service.HldService;
import com.yss.datamiddle.util.HttpClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 测试类
 * @author: Han LiDong
 * @create: 2020/12/3 16:07
 * @update: 2020/12/3 16:07
 */
public class HldServiceImpl implements HldService {

    public String work(){
        Map<String,Object> result = new HashMap<>();
        //设置请求头信息
        Map<String,String> header = new HashMap<>();
        header.put("token", "19d18ee4fde86febfad0a72b67715d74");
        //设置请求体参数
        Map<String,Object> body = new HashMap<>();
        body.put("pageSize",10);
        body.put("pageNo",1);

        String resultStr = HttpClient.sendGetRequest("http://192.168.100.80:6789/scheduler/v2/projects/multipleCheck/instance/list-paging",body,header);

        return resultStr;
    }

}
