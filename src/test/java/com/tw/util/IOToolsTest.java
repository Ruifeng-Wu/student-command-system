package com.tw.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/6 23:03
 */
public class IOToolsTest {

    @Test
    public void return_int_request() {
        String data = String.valueOf(1);
        InputStream in = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(1, IOTools.getRequest());
        } finally {
            System.setIn(in);
        }
    }

    @Test
    public void return_input_message() {
        String data = "Hello World!";
        InputStream in = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(data, IOTools.getMessage());
        } finally {
            System.setIn(in);
        }
    }

    @Test
    public void return_display_message() throws Exception {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String data = "Hello World!";
        IOTools.display(data);
        assertThat(outContent.toString(), containsString(data));
    }
}
