package com.atf.pageElement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ice on 2017/2/17.
 */
public class TimeUtil {

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return df.format(new Date());
    }

}
