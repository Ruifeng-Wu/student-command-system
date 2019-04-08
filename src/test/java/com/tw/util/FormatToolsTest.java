package com.tw;

import com.tw.util.Constants;
import com.tw.util.FormatTools;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/5 19:01
 */
public class FormatToolsTest {

    @Test
    public void check_student_info_validate_true(){
        String input="小花, 20190405001, 汉, 语文: 80, 英语: 85, 编程: 100, 数学: 98";
        assertTrue("should return 'true'",FormatTools.validate(input, Constants.STUDENT_INFOMATION_PATTERN));
    }
    @Test
    public void check_student_info_validate_false(){
        String input="小花, 201904050012, 汉, 语文: 80, 英语:85, 编程: 100, 数学: 98";
        assertTrue("should return 'true'",FormatTools.validate(input,Constants.STUDENT_INFOMATION_PATTERN));
    }
    @Test
    public void check_student_id_validate_true(){
        String input="20190405002, 20190405002";
        assertTrue("should return 'true'",FormatTools.validate(input,Constants.STUDENT_ID_PATTERN));
    }
}
