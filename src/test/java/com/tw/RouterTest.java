package com.tw;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;


/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 10:47
 */
public class RouterTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Router router;

    @Before
    public void setup() {
        router = new Router();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void home_command() {
        String expected = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：";
        String actual = router.route(0);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void exit_command() {
        Router router = mock(Router.class);
        Mockito.doCallRealMethod().when(router).route(1);
        //ExitCommand exitCommand = mock(ExitCommand.class);
        //verify(exitCommand).invoke();
    }
}
