package com.tw;

import org.junit.Test;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/3 11:47
 */
public class RouterTest {
    @Test
    public void home_command() {
        Router router=new Router();
        String actual=router.route(0);
        String expected="1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：";
        assertThat(actual,equalTo(expected));

    }

}
