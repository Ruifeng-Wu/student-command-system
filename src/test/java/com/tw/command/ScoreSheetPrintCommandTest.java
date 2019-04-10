package com.tw.command;

import com.tw.Pojo.ScoreSheet;
import com.tw.command.impl.ScoreSheetPrintCommand;
import com.tw.util.FormatTools;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/6 23:05
 */
public class ScoreSheetPrintCommandTest {

    private ScoreSheet scoreSheet;
    private ScoreSheetPrintCommand scoreSheetPrintCommand;

    @Before
    public void setup() {
        scoreSheetPrintCommand = new ScoreSheetPrintCommand();
        scoreSheet = new ScoreSheet();
        String stu = "小黑, 20200102003, 汉, 数学: 99.0, 语文: 85.0, 英语: 85.0, 编程: 100.0";
        scoreSheet.addStudent(FormatTools.convertToObj(stu));
        scoreSheet.setSelectIds(new String[]{"20190506001", "20200102003"});
    }

    @Test
    public void return_score_sheet_string() {
        String excepted = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "小黑|99.0|85.0|85.0|100.0|92.25|369.0\n" +
                "========================\n" +
                "全班总分平均数：369.0\n" +
                "全班总分中位数：369.0";
        assertThat(scoreSheetPrintCommand.buildScoreSheetString(scoreSheet), containsString(excepted));
    }

}
