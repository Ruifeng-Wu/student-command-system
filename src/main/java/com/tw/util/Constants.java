package com.tw.util;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 22:31
 */
public class Constants {
    public static final String MAIN_MENU = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出" +
            "请输入你的选择（1～3）：";
    private static final String STUDENT_INPUT_FORMAT = "（格式：姓名, 学号, 民族, 学科: 成绩, ...）";
    private static final String GRADE_LIST_FORMAT = "（格式： 学号, 学号,...）";
    public static final String STUDENT_INPUT_MESSAGE = String.format("请输入学生信息%s，按回车提交：", STUDENT_INPUT_FORMAT);
    public static final String STUDENT_INPUT_FORMAT_ERROR = String.format("请按正确的格式输入%s：", STUDENT_INPUT_FORMAT);
    public static final String STUDENT_INPUT_SUCCESS_MESSAGE = "学生%s的成绩被添加";
    public static final String GRADE_LIST_MESSAGE = String.format("请输入要打印的学生的学号%s，按回车提交：", GRADE_LIST_FORMAT);
    public static final String GRADE_LIST_FORMAT_ERROR = String.format("请按正确的格式输入要打印的学生的学号%s，按回车提交：", GRADE_LIST_FORMAT);
    public static final String GRADE_LIST_HEADER = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分\n" +
            "========================\n";
    public static final String GRADE_LIST_BODY = "%s|%s|%s|%s|%s|%s|%s\n";
    public static final String GRADE_LIST_FOOTER = "========================\n" +
            "全班总分平均数：%s\n" +
            "全班总分中位数：%s\n";
    public static final String STUDENT_INFOMATION_PATTERN = "^[\\u4e00-\\u9fa5]{2,4}, [0-9]{11}, [\\u4e00-\\u9fa5]{1,4}" +
            "(?=.*, 语文: ([1-9][0-9]?|100))(?=.*, 数学: ([1-9][0-9]?|100))(?=.*, 英语: ([1-9][0-9]?|100))(?=.*, 编程: ([1-9][0-9]?|100)).*$";

    public static final String STUDENT_ID_PATTERN = "[0-9]{11}(, [0-9]{11})*";
}
