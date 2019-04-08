package com.tw.util;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/8 22:26
 */
public class IOTools {

   public static PrintStream out;
    public static Scanner in;

    static  {
        in = new Scanner(System.in);
        out = new PrintStream(System.out);
    }

    public static int getRequest() {
        return in.nextInt();
    }

    public static String getMessage() {
        String str=in.nextLine();
        while(str.length()==0) {
            str=in.nextLine();
        }
        return str;
    }

    public static void display(String msg) {
        out.println(msg);
        out.flush();
    }
    public static void close(){
        out.close();
        in.close();
    }
}
