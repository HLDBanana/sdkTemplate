package com.yss.datamiddle.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 创建调度平台工厂的工厂类
 * @author: Han LiDong
 * @create: 2020/12/4 16:18
 * @update: 2020/12/4 16:18
 */
@Slf4j
public class ScheduleFactory {

    public static Factory getFactory(String factoryType){
        if (factoryType == null || "".equals(factoryType.trim())){
            log.error("type 不能为空");
            return null;
        }
        if ("etl".equals(factoryType)){
            return new EtlFactory();
        } else {
            log.error("type 不存在");
            return null;
        }
    }
}
