package com.tw.command.impl;

import com.tw.command.Command;
import com.tw.util.Constants;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 11:50
 */
public class HomeCommand implements Command {
    @Override
    public String invoke() {
        return Constants.MAIN_MENU;
    }
}
