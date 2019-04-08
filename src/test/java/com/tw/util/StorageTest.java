package com.tw.util;

import com.tw.Pojo.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 10:15
 */
public class StorageTest {
    private Student student;

    @Before
    public void init() {
        student = new Student();
        student.setName("tom");
        student.setId("20190405001");
        student.setNation("回");
        student.setMath(98);
        student.setChinese(90);
        student.setEnglish(85);
        student.setProgramming(100);
        student.summary();
    }


    @Test
    public void findAll() {
        Storage.add(student);
        List<String> stuStr = Storage.findAll();
        assertEquals("tom, 20190405001, 回, 数学: 98.0, 语文: 90.0, 英语: 85.0, 编程: 100.0, 平均分: 93.25, 总分: 373.0", stuStr.get(stuStr.size() - 1).toString());
    }

    @Test
    public void add() {
        assertTrue("should return true", Storage.add(student));
    }
}
