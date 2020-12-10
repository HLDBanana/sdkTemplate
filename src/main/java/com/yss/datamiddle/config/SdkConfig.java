package com.yss.datamiddle.config;

import com.yss.datamiddle.common.SdkConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:  SdkConfigProperties读取客户端配置
 * @author: Han LiDong
 * @create: 2020/12/3 14:57
 * @update: 2020/12/3 14:57
 */
@Configuration
@EnableConfigurationProperties(SdkConfigProperties.class)    //读取客户端配置项
public class SdkConfig {

}
