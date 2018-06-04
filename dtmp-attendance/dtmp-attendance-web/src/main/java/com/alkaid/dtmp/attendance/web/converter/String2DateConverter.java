package com.alkaid.dtmp.attendance.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String text) {
        Date date = null;
        try {
            if(text.contains("-")){
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                date = sf.parse(text);
            }else {
                SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                date = sf.parse(text);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
