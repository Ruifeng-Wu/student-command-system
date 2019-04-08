package com.tw.Pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 19:10
 */
public class ScoreSheet {
    private List<Student> studentList;
    private double totalAverage;
    private double totalMedian;
    private String[] selectIds;

    public String[] getSelectIds() {
        return selectIds;
    }

    public void setSelectIds(String[] selectIds) {
        this.selectIds = selectIds;
    }

    public ScoreSheet() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        summary();
    }

    public void summary() {
        double[] totalScores = studentList.stream().mapToDouble(Student::getTotal).toArray();
        double amount = Arrays.stream(totalScores).sum();
        totalAverage = amount / totalScores.length;
        Arrays.sort(totalScores);
        int index = totalScores.length / 2 > 0 ? totalScores.length / 2 : 0;
        totalMedian = (totalScores.length % 2 == 0) ? (totalScores[index] + totalScores[index - 1]) / 2 : totalScores[index];
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public double getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(double totalAverage) {
        this.totalAverage = totalAverage;
    }

    public double getTotalMedian() {
        return totalMedian;
    }

    public void setTotalMedian(double totalMedian) {
        this.totalMedian = totalMedian;
    }

    @Override
    public String toString() {
        return "ScoreSheet{" +
                "studentList=" + studentList +
                ", totalAverage=" + totalAverage +
                ", totalMedian=" + totalMedian +
                '}';
    }
}
