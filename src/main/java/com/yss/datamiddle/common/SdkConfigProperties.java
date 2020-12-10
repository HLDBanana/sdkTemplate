package com.yss.datamiddle.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述： 读取客户端调度平台基础配置
 * @Author hld
 * @Date 2020/12/7 14:08
 * @Version V1.0
 **/
@ConfigurationProperties(prefix = "yss.datamiddle.sdk")   //读取客户端配置项
public class SdkConfigProperties {
    /**
     * 调度平台token
     */
    private String token;
    /**
     * 调度平台ip地址
     */
    private String ip;
    /**
     * 调度平台端口
     */
    private String port;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
