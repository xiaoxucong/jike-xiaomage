package org.geektimes.configuration.microprofile.config;

import org.geektimes.configuration.microprofile.config.source.JavaSystemPropertiesConfigSource;

import java.util.Map;

public class MyConfigTest {

    public static void main(String[] args) throws Exception {
        test4();
    }

    //获取注册表的所有的配置信息
    static  void test1() {
        JavaSystemPropertiesConfigSource jspcs= new JavaSystemPropertiesConfigSource();
        Map<String,Object> map=  jspcs.getWinAllProperty();
        for (String key : map.keySet()) {
            Object val = map.get(key);
            System.out.println(key + ": " + val);
        }
    }

    //获取项目中所有的properties文件的配置信息
    static  void test2() {
        JavaSystemPropertiesConfigSource jspcs= new JavaSystemPropertiesConfigSource();
        Map<String,String> map=  jspcs.getLocalAllProperty();
        for (String key : map.keySet()) {
            String val = map.get(key);
            System.out.println(key + ": " + val);
        }
    }

    //类型转换
    static void test3() throws Exception {
        Byte b = MyConverter.convertByte("1");
        System.out.println("Byte=" + b);
        Short s = MyConverter.convertShort("2");
        System.out.println("Short=" + s);
        Integer i = MyConverter.convertInteger("3");
        System.out.println("Integer=" + i);
        Long l = MyConverter.convertLong("4");
        System.out.println("Long=" + l);
        Boolean bl = MyConverter.convertBoolean("4");
        System.out.println("Boolean=" + bl);
        Float f = MyConverter.convertFloat("5.0");
        System.out.println("Float=" + f);
        Double d = MyConverter.convertDouble("6.0");
        System.out.println("Double=" + d);
    }
    //获取项目中项目名
    static  void test4() {
        System.out.println(  "项目名称" + JavaConfig.getProjectName());
    }

}
