package com.mikes.server.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期转换工具
 */
@Component
public class DateUtils implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {
        try{
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
