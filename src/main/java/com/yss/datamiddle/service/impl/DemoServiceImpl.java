package com.yss.datamiddle.service.impl;

import com.yss.datamiddle.common.ETLUrls;
import com.yss.datamiddle.common.SdkConfigProperties;
import com.yss.datamiddle.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述： 测试读取客户端配置项
 * @Author shf
 * @Date 2019/5/7 21:59
 * @Version V1.0
 **/
public class DemoServiceImpl implements DemoService {

    @Autowired
    public SdkConfigProperties sdkConfigProperties;

    @Autowired
    public ETLUrls etlUrls;

    public DemoServiceImpl(){};

    public String say(){
        return "token = " + sdkConfigProperties.getToken() + ", ip = " + sdkConfigProperties.getIp() + ", port = " + sdkConfigProperties.getPort();
    }

    public String etlParams(){
        return etlUrls.getHttpCheckCondition() + etlUrls.getHttpParametersType();
    }
}
