package com.alexbzmn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 7/16/2017.
 */
public final class Util {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");

    public static String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static Date strToDate(String strDate) {
        try {
            return format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }
}
