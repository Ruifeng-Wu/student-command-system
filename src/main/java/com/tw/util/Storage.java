package com.tw.util;

import com.tw.Pojo.Student;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 10:22
 */
public class Storage {
    private static String PATH = "src/StudentInfo";


    public static boolean add(Student student) {
        String stuInfo = student.toString() + "\n";
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(PATH, true);
            fos.write(stuInfo.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<String> findAll() {
        List<String> stuInfos = new ArrayList<>();
        try {
            FileReader fr = new FileReader(PATH);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                stuInfos.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuInfos;
    }
}
