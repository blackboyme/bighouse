package com.cryingbear.blog.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {

    public static void main(String[] args) {
        String s = "2www(11)";
        String regex = "^\\s+\\(\\d+\\)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        Boolean isTrue = matcher.find();
        System.out.println("是否满足"+isTrue);
    }
}
