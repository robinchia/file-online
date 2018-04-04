package com.venustech.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author robin(贾永伟)
 * @PackgeName: com.venustech.utils
 * @Description: 请添加描述...
 * @date 18-4-2 13:23
 */
@Component
public class ShedulerClean {
     Logger logger= LoggerFactory.getLogger(ShedulerClean.class);
    @Value("${file.dir}")
    String fileDir;

//    @Scheduled(cron = "0 0 23 * * ?")   //每晚23点执行一次
    public void clean(){
        logger.info("执行一次清空文件夹");
        DeleteFileUtil.deleteDirectory(fileDir);
    }
}
