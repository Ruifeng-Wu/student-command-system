package com.tw.command;

import com.tw.Pojo.Student;
import com.tw.command.impl.AddStudentInfoCommand;
import com.tw.service.ScoreService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/6 23:05
 */
public class AddStudentInfoCommandTest {


    @Test
    public void return_add_student_information() {
        ScoreService service = mock(ScoreService.class);
        Student student = mock(Student.class);
        AddStudentInfoCommand command = mock(AddStudentInfoCommand.class);
        doReturn(service).when(command).createService();
        doReturn(student).when(service).getStudent();
        when(student.getName()).thenReturn("小花");
        when(command.addStudentInfo(any())).thenReturn(true);
        when(command.invoke()).thenCallRealMethod();
        assertThat(command.invoke(), containsString("学生小花的成绩被添加"));
    }
}
