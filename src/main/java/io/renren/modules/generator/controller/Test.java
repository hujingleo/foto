package io.renren.modules.generator.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {


    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat test = new SimpleDateFormat("yyyy,MM,dd");

        System.out.println(test.format(calendar.getTime()));
    }
}

