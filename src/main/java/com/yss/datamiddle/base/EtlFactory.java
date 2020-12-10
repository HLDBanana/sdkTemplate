package com.yss.datamiddle.base;

import com.yss.datamiddle.service.impl.ProcessInstallImpl;

/**
 * @description:  创建具体的实现类
 * @author: Han LiDong
 * @create: 2020/12/4 16:24
 * @update: 2020/12/4 16:24
 */
public class EtlFactory extends Factory{

    @Override
    public EtlBaseService createImplementation(String type) {
        if (type != null && !"".equals(type)){
            if (type.equals("process")){
                return new ProcessInstallImpl();
            }
        }
        return null;
    }
}
