package com.cryingbear.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {

    public static void main(String[] args) {
        String s = "2www(11111)";
        String regex = "\\(\\d{4}\\)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        Boolean isTrue = matcher.find();
        System.out.println("是否满足"+isTrue);
        System.out.println(3/2);
        List<String> list = new ArrayList<>();


    }

}
