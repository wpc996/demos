package com.wpc;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangpeican
 * @date 2022/3/24 22:32
 */
public class LogTest {
//    private static Logger logger = LogManager.getLogger(LogTest.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog4j2() {
        logger.info("info");
    }
}
