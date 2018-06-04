package com.alkaid.dtmp.attendance.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Date2StringConverter implements Converter<Date, String> {
    @Override
    public String convert(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = sf.format(date);
        return dateString;
    }
}
