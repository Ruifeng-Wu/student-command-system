package com.tw.command;

import com.tw.command.impl.HomeCommand;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/6 23:04
 */
public class HomeCommandTest {
    @Test
    public void return_main_menu(){
        HomeCommand homeCommand=mock(HomeCommand.class);
        Mockito.doCallRealMethod().when(homeCommand).invoke();
        String mainMenu="1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出" +
                "请输入你的选择（1～3）：";
        assertThat("should return true",homeCommand.invoke(),equalTo(mainMenu));
    }
}
