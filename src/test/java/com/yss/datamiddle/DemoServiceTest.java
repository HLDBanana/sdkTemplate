package com.yss.datamiddle;

import com.yss.datamiddle.base.ScheduleFactory;
import com.yss.datamiddle.service.impl.DemoServiceImpl;
import com.yss.datamiddle.service.impl.ProcessInstallImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2020/12/7 10:52
 * @update: 2020/12/7 10:52
 */
@Slf4j
public class DemoServiceTest {


    @Test
    public void test() throws IOException {
        String res = ((ProcessInstallImpl) ScheduleFactory.getFactory("etl").createImplementation("process")).execute();
        log.info(res);
    }

}
