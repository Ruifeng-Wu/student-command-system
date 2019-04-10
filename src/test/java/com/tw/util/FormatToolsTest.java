package com.tw.util;

import com.tw.Pojo.Student;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/6 19:01
 */
public class FormatToolsTest {

    @Test
    public void return_true_with_check_student_info_validate() {
        String input = "小花, 20190405001, 汉, 语文: 80, 英语: 85, 编程: 100, 数学: 98";
        assertTrue("should return 'true'", FormatTools.validate(input, Constants.STUDENT_INFOMATION_PATTERN));
    }

    @Test
    public void return_false_with_check_student_info_validate() {
        String input = "小花, 201904050012, 汉, 语文: 80, 英语:85, 编程: 100, 数学: 98";
        assertFalse("should return 'false'", FormatTools.validate(input, Constants.STUDENT_INFOMATION_PATTERN));
    }

    @Test
    public void return_true_with_check_student_id_validate() {
        String input = "20190405002, 20190405002";
        assertTrue("should return 'true'", FormatTools.validate(input, Constants.STUDENT_ID_PATTERN));
    }

    @Test
    public void return_false_with_check_student_id_validate() {
        String input = "2019040500x2, 20190405002";
        assertFalse("should return 'false'", FormatTools.validate(input, Constants.STUDENT_ID_PATTERN));
    }

    @Test
    public void should_return_student_object() {
        String str = "tom, 20190405001, 回, 数学: 98.0, 语文: 90.0, 英语: 85.0, 编程: 100.0, 平均分: 93.25, 总分: 383.0";
        Object obj = FormatTools.convertToObj(str);
        assertTrue("should return true", Student.class.isInstance(obj));
        Student student = new Student();
        student.setName("tom");
        student.setId("20190405001");
        student.setNation("回");
        student.setMath(98);
        student.setChinese(90);
        student.setEnglish(85);
        student.setProgramming(100);
        student.summary();
        assertThat(obj.toString(), containsString(student.toString()));
    }
}
