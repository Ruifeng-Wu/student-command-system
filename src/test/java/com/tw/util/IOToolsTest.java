package com.tw.util;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 23:03
 */
public class IOToolsTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before

    public void setup() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void return_int_request() {
        String input = String.valueOf(1);
        new ByteArrayInputStream(input.getBytes());
        System.out.println(IOTools.getRequest());
    }
}
