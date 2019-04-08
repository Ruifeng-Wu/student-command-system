package com.tw.command.impl;

import com.tw.command.Command;
import com.tw.util.IOTools;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/8 16:09
 */
public class ExitCommand implements Command{
    @Override
    public String invoke() {
        IOTools.close();
        System.exit(0);
        return null;
    }
}
