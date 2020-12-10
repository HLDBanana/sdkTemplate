package com.yss.datamiddle.service.impl;

import com.yss.datamiddle.base.EtlBaseService;
import com.yss.datamiddle.service.ProcessInstall;
import com.yss.datamiddle.util.HttpClient;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 工厂模式创建实现类
 * @author: Han LiDong
 * @create: 2020/12/4 16:13
 * @update: 2020/12/4 16:13
 */
public class ProcessInstallImpl extends EtlBaseService implements ProcessInstall {

    public String execute() {
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
