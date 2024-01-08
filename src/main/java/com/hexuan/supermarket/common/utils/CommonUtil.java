package com.hexuan.supermarket.common.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author hexuan
 * @Date 2023/9/5 17:56
 * @PackageName:com.hexuan.config
 * @ClassName: CommonUtil
 * @Description: TODO
 */
@Component
public class CommonUtil {
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}
