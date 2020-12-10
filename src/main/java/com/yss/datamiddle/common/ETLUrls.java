package com.yss.datamiddle.common;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: ETL调用接口引用
 * @author: Han LiDong
 * @create: 2020-07-20 14:00:00
 * @update: 2020-07-20 14:00:00
 */
@Component
@Data
@PropertySource("classpath:application.properties")
public class ETLUrls {

    Logger log = LoggerFactory.getLogger(ETLUrls.class);

    /**
     * api接口默认配置
     */
    /**
     * http工作流默认配置
     */
    @Value("${multiplecheck.process.processDefinitionJson.tasks.params.localParams.direct}")
    private String direct;
    @Value("${multiplecheck.process.processDefinitionJson.tasks.params.localParams.type}")
    private String localparamsType;                        //参数类型
    @Value("${multiplecheck.process.processDefinitionJson.tasks.params.httpParams.httpParametersType}")
    private String httpParametersType;          //PARAMETER/BODY/HEADERS     请求行/请求体/请求头
    @Value("${multiplecheck.process.processDefinitionJson.tasks.params.httpCheckCondition}")
    private String httpCheckCondition;          //STATUS_CODE_DEFAULT:默认响应码200      STATUS_CODE_CUSTOM：自定义响应码       BODY_CONTAINS：内容包含      BODY_NOT_CONTAINS：内容不包含
    @Value("${multiplecheck.process.processDefinitionJson.tasks.params.connectTimeout}")
    private Integer connectTimeout;          //连接超时
    @Value("${multiplecheck.process.processDefinitionJson.tasks.params.socketTimeout}")
    private Integer socketTimeout;          //socket超时
    @Value("${multiplecheck.process.processDefinitionJson.tasks.conditionResult.successNode}")
    private String successNode;
    @Value("${multiplecheck.process.processDefinitionJson.tasks.conditionResult.failedNode}")
    private String failedNode;
    @Value("${multiplecheck.process.processDefinitionJson.tasks.runFlag}")
    private String runFlag;
    @Value("${multiplecheck.process.processDefinitionJson.tasks.maxRetryTimes}")
    private String maxRetryTimes;           //失败重试次数
    @Value("${multiplecheck.process.processDefinitionJson.tasks.retryInterval}")
    private String retryInterval;             //重试间隔
    @Value("${multiplecheck.process.processDefinitionJson.tasks.timeout.enable}")
    private String enable;                  //true/false   超时告警开关
    @Value("${multiplecheck.process.processDefinitionJson.tasks.timeout.interval}")
    private Integer interval;                  //true/false   超时告警开关
    @Value("${multiplecheck.process.processDefinitionJson.tasks.timeout.strategy}")
    private String strategy;                //FAILED:超时失败    WARN:超时告警
    @Value("${multiplecheck.process.processDefinitionJson.tasks.taskInstancePriority}")
    private String taskInstancePriority;    //任务优先级 HIGHEST>HIGH>MEDIUM>LOW>LOWEST
    @Value("${multiplecheck.process.processDefinitionJson.tasks.workerGroup}")
    private String workerGroup;             //worker分组
    @Value("${multiplecheck.process.processDefinitionJson.tenantId}")
    private Integer tenantId;                //#超时告警时长
    @Value("${multiplecheck.process.processDefinitionJson.timeout}")
    private Integer timeout;
    @Value("${multiplecheck.process.locations.tasks.nodenumber}")
    private String nodenumber;
    @Value("${multiplecheck.process.locations.tasks.x}")
    private String x;
    @Value("${multiplecheck.process.locations.tasks.y}")
    private String y;
    @Value("${multiplecheck.process.locations.tasks.targetarr}")
    private String targetarr;
    @Value("${multiplecheck.process.labelIds}")
    private String labelIds;
    @Value("${multiplecheck.process.processDefinitionJson.tasks.type}")
    private String type;


    /**
     * 定时任务默认
     * 配置
     */
    @Value("${multiplecheck.schedule.failureStrategy}")
    private String failureStrategy;             //失败策略 CONTINUE：继续   END：结束
    @Value("${multiplecheck.schedule.warningType}")
    private String warningType;                 //通知策略 NONE：都不发    SUCCESS：成功发     FAILURE：失败发     ALL：成功失败都发
    @Value("${multiplecheck.schedule.processInstancePriority}")
    private String processInstancePriority;     //#任务优先级 HIGHEST>HIGH>MEDIUM>LOW>LOWEST
    @Value("${multiplecheck.schedule.warningGroupId}")
    private String warningGroupId;              //#通知组
    @Value("${multiplecheck.schedule.receivers}")
    private String receivers;                    //收件人
    @Value("${multiplecheck.schedule.receiversCc}")
    private String receiversCc;                 //抄送人
    @Value("${multiplecheck.schedule.workerGroup}")
    private String scheduleWorkerGroup;         //worker分组


}
