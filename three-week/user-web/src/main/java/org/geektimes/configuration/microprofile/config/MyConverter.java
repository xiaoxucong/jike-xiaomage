package org.geektimes.configuration.microprofile.config;

import org.eclipse.microprofile.config.spi.Converter;

/***
 * 扩展 org.eclipse.microprofile.config.spi.Converter
 * 实现，提供 String 类型到简单类型
 */
public class MyConverter implements Converter {
    @Override
    public Object convert(String s) throws IllegalArgumentException, NullPointerException {
        return s;
    }
    public static Byte convertByte(String s) throws  Exception {
        return Byte.valueOf(s);
    }
    public static Short convertShort(String s) throws  Exception {
        return Short.valueOf(s);
    }
    public static Integer convertInteger(String s) throws  Exception {
        return Integer.valueOf(s);
    }
    public static  Long convertLong(String s) throws  Exception {
        return Long.valueOf(s);
    }
    public static Float convertFloat(String s) throws  Exception {
        return Float.valueOf(s);
    }
    public static Double convertDouble(String s) throws  Exception {
        return Double.valueOf(s);
    }
    public static Boolean convertBoolean(String s) throws  Exception {
        return Boolean.valueOf(s);
    }
}
