package com.tw.command.impl;

import com.tw.Pojo.ScoreSheet;
import com.tw.Pojo.Student;
import com.tw.command.Command;
import com.tw.service.ScoreService;
import com.tw.util.Constants;
import com.tw.util.IOTools;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 15:54
 */
public class ScoreSheetPrintCommand implements Command {

    @Override
    public String invoke() {
        String idStr = "";
        ScoreService service = new ScoreService();
        ScoreSheet scoreSheet;
        IOTools.display(Constants.GRADE_LIST_MESSAGE);
        idStr = IOTools.getMessage();
        scoreSheet = service.generateScoreSheet(idStr);
        return buildScoreSheetString(scoreSheet, idStr);
    }


    public String buildScoreSheetString(ScoreSheet scoreSheet, String idStr) {
        String scoreSheetString = Constants.GRADE_LIST_HEADER;
        String[] ids = idStr.split(", ");
        for (String id : ids
                ) {
            for (Student stu : scoreSheet.getStudentList()
                    ) {
                if (stu.getId().equals(id)) {
                    scoreSheetString += String.format(Constants.GRADE_LIST_BODY, stu.getName(), stu.getMath(), stu.getChinese(), stu.getEnglish(), stu.getProgramming(), stu.getAverage(), stu.getTotal());
                }
            }
        }
        scoreSheetString += String.format(Constants.GRADE_LIST_FOOTER, scoreSheet.getTotalAverage(), scoreSheet.getTotalMedian());
        return scoreSheetString;
    }
}
