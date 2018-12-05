package io.renren.modules.generator.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {


    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
        try {
            Date d = sdf.parse("1603190000");
            System.out.println(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
//        Calendar calendar = Calendar.getInstance();

//        Date date = new Date();
//        SimpleDateFormat test = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
//
//        System.out.println(test.format(date));
//        System.out.println(date);
//        System.out.println(calendar);


