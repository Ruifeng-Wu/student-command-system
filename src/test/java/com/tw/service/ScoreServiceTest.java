package com.tw.service;

import com.tw.Pojo.ScoreSheet;
import com.tw.Pojo.Student;
import com.tw.util.FormatTools;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 16:34
 */
public class ScoreServiceTest {
    //private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ScoreService service;
    private Student student;
    private ScoreSheet scoreSheet;

    @Before
    public void setup() {
        student = new Student();
        service = new ScoreService();
        scoreSheet = new ScoreSheet();
        student.setName("tom");
        student.setId("20190405001");
        student.setNation("回");
        student.setMath(98);
        student.setChinese(90);
        student.setEnglish(85);
        student.setProgramming(100);
        student.summary();
        //System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_return_false_when_add_student() {
        String input = "小花, 20190405001, 汉, 数: 98.0, 语文: 80.0, 英语: 85.0, 编程: 100.0";
        assertFalse("shoule return false", service.addStudentInfo(input));
    }

    @Test
    public void should_return_true_when_add_student() {
        String input = "小花, 20190405001, 汉, 数学: 98.0, 语文: 80.0, 英语: 85.0, 编程: 100.0";
        assertTrue("shoule return true", service.addStudentInfo(input));
    }

    @Test
    public void return_points() {
        service.getPoints(student);
        String actual = student.toString();
        String expected = "tom, 20190405001, 回, 数学: 98.0, 语文: 90.0, 英语: 85.0, 编程: 100.0, 平均分: 93.25, 总分: 383.0";
        assertEquals(expected, actual);
    }

    @Test
    public void generate_score_sheet() {
        ScoreSheet scoreSheetExcepted = new ScoreSheet();
        String stu = "小绿, 20200405001, 汉, 数学: 98.0, 语文: 80.0, 英语: 85.0, 编程: 100.0";
        scoreSheetExcepted.getStudentList().add(FormatTools.convertToObj(stu));
        scoreSheetExcepted.summary();
        service.addStudentInfo(stu);
        String input = "20200405001, 20190905001";
        scoreSheet = service.generateScoreSheet(input);
        assertThat(scoreSheet.toString(), equalTo(scoreSheetExcepted.toString()));
    }


}
