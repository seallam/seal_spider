package com.seal.spider.jar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hasee on 2017/6/26.
 */
public class Provider {
    private static final Logger logger = LoggerFactory.getLogger(Provider.class);
    private static volatile boolean running = true;

    public static void main(final String[] args) {
        try {
            String profile = "development";
            if (args != null && args.length > 0) {
                profile = args[0];
            }
            System.setProperty("spring.profiles.active", profile);
            new ClassPathXmlApplicationContext("conf/seal-spider-context.xml");
            logger.info(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " service server started!");
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            System.exit(1);
        }
//        synchronized (Main.class) {
//            while (running) {
//                try {
//                    Provider.class.wait();
//                } catch (Throwable e) {
//                }
//            }
//        }
        com.alibaba.dubbo.container.Main.main(args);
    }
}
