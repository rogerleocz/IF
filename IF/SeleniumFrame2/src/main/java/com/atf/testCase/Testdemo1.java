package com.atf.testCase;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ice on 2017/2/21.
 */
public class Testdemo1 {

    public static void main(String[] args) {

        HashMap<String,String> hm = new HashMap<String,String>();

        hm.put("username","password");
        hm.put("Jim","1155689");
        hm.put("Jane","1255669");
        hm.put("Kevin","1165669");

        //对比测试返回值是否包含username，ture还是false
        System.out.println(hm.containsKey("username"));
        System.out.println("-----------------------------");

        //获取Keys对应的value
        System.out.println(hm.get("Jim"));
        System.out.println("-----------------------------");

//        //获取整个字典表
        System.out.println(hm.entrySet());
        System.out.println("-----------------------------");

//        //循环打印每一对key:value
        Iterator<?> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("-----------------------------");
        }

//        //分别获取key的值，和value的值
        Iterator<String> it2 =hm.keySet().iterator();
        while(it2.hasNext()){
            //获取字典表key
            String username = it2.next();
            System.out.println(username);
            //获取字典表value
            String password =hm.get(username);
            System.out.println(password);
        }

    }
}
