package com.yss.datamiddle.base;

/**
 * @description: 具体功能模块抽象类
 * @author: Han LiDong
 * @create: 2020/12/4 16:19
 * @update: 2020/12/4 16:19
 */
public abstract class Factory {

    public abstract EtlBaseService createImplementation(String type);

}
