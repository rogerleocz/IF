package com.atf.pageElement;

import com.atf.Interface.ConstantKeys;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by ice on 2017/2/14.
 */
public class LoadProperties {

    /**
     * 读取config.properties中的value
     * @param key
     * @return
     */
    public String getConfigByKey(String key){

        String value =null;

        Properties properties =new Properties();
        try {
            properties.load(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(ConstantKeys.CommonKey),"UTF-8"));
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
