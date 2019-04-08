package com.tw.service;

import com.tw.Pojo.ScoreSheet;
import com.tw.Pojo.Student;
import com.tw.util.Constants;
import com.tw.util.FormatTools;
import com.tw.util.IOTools;
import com.tw.util.Storage;

import java.util.List;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 15:16
 */
public class ScoreService {
    private Student student;
    private ScoreSheet scoreSheet;

    public Student getStudent() {
        return student;
    }

    public ScoreSheet getScoreSheet() {
        return scoreSheet;
    }

    public boolean addStudentInfo(String input) {
        if (FormatTools.validate(input, Constants.STUDENT_INFOMATION_PATTERN)) {
            student = FormatTools.convertToObj(input);
            getPoints(student);
            if (Storage.add(student)) {
                return true;
            }
        }
        return false;
    }

    public boolean getPoints(Student stu) {
        if (!stu.getNation().equals("汉")) {
            stu.setTotal(stu.getTotal() + 10);
            return true;
        }
        return false;
    }

    public ScoreSheet generateScoreSheet() {
        String input=IOTools.getMessage();
        while (!FormatTools.validate(input, Constants.STUDENT_ID_PATTERN)) {
            IOTools.display(Constants.GRADE_LIST_FORMAT_ERROR);
            input=IOTools.getMessage();
        }
        scoreSheet=buildScoreSheetObject(Storage.findAll());
        scoreSheet.setSelectIds(input.split(", "));
        return scoreSheet;
    }

    public ScoreSheet buildScoreSheetObject(List<String> students) {
        scoreSheet = new ScoreSheet();
        for (String student : students) {
            scoreSheet.addStudent(FormatTools.convertToObj(student));
        }
        return scoreSheet;
    }
}
