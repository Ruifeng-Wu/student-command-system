package com.tw;

import com.tw.util.Constants;
import com.tw.util.IOTools;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 15:55
 */
public class StudentGradeSystem {
    public static void main(String[] args) {
        Router route = new Router();
        while (true) {
            IOTools.display(Constants.MAIN_MENU);
            IOTools.display(route.route(IOTools.getRequest()));
        }
    }
}
