package com.tw.util;

import com.tw.Pojo.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/8 19:20
 */
public class FormatTools {



    public static boolean validate(String input, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public static Student convertToObj(String str) {

        Student student = new Student();
        String[] items = str.split(", ");
        student.setName(items[0]);
        student.setId(items[1]);
        student.setNation(items[2]);
        String[] score;
        for (int i = 3; i < items.length; i++) {
            score = items[i].split(": ");
            student.setScore(score[0], Double.parseDouble(score[1]));
        }
        student.summary();
        return student;
    }
}
