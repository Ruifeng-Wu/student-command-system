package com.tw.Pojo;

import java.io.Serializable;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 18:09
 */
public class Student implements Serializable {
    private String name;
    private String id;
    private String nation;
    private double math;
    private double chinese;
    private double english;
    private double programming;
    private double average;
    private double total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getProgramming() {
        return programming;
    }

    public void setProgramming(double programming) {
        this.programming = programming;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void summary() {
        total = getMath() + getChinese() + getEnglish() + getProgramming();
        average = total / 4;
    }

    public void setScore(String name, double score) {
        switch (name) {
            case "数学":
                setMath(score);
                break;
            case "语文":
                setChinese(score);
                break;
            case "英语":
                setEnglish(score);
                break;
            case "编程":
                setProgramming(score);
                break;
            case "平均分":
                setAverage(score);
                break;
            case "总分":
                setTotal(score);
                break;
            default:
                return;
        }
    }

    @Override
    public String toString() {
        return name +
                ", " + id +
                ", " + nation +
                ", " + "数学: " + math +
                ", " + "语文: " + chinese +
                ", " + "英语: " + english +
                ", " + "编程: " + programming +
                ", " + "平均分: " + average +
                ", " + "总分: " + total;
    }
}
