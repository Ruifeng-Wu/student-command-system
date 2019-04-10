package com.tw.command;

import com.tw.command.impl.AddStudentInfoCommand;
import com.tw.util.Constants;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/6 23:05
 */
public class AddStudentInfoCommandTest {

    public void return_add_student_success(){
        AddStudentInfoCommand command=mock(AddStudentInfoCommand.class);
        when(command.invoke()).thenReturn(Constants.STUDENT_INPUT_SUCCESS_MESSAGE);
    }
}
