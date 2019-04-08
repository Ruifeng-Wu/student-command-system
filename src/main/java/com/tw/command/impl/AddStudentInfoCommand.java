package com.tw.command.impl;

import com.tw.command.Command;
import com.tw.service.ScoreService;
import com.tw.util.Constants;
import com.tw.util.IOTools;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 15:52
 */
public class AddStudentInfoCommand implements Command {
    @Override
    public String invoke() {
        ScoreService service = new ScoreService();
        IOTools.display(Constants.STUDENT_INPUT_MESSAGE);
        boolean flag = service.addStudentInfo(IOTools.getMessage());
        while (!flag) {
            IOTools.display(Constants.STUDENT_INPUT_FORMAT_ERROR);
            flag = service.addStudentInfo(IOTools.getMessage());
        }
        return String.format(Constants.STUDENT_INPUT_SUCCESS_MESSAGE, service.getStudent().getName());
    }
}