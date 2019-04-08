package com.tw;

import com.tw.command.Command;
import com.tw.command.impl.AddStudentInfoCommand;
import com.tw.command.impl.ExitCommand;
import com.tw.command.impl.HomeCommand;
import com.tw.command.impl.ScoreSheetPrintCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruifeng-Wu
 * @Email 296078293@qq.com
 * @date 2019/4/7 10:04
 */
public class Router {
    private Map<Integer, Command> pathMap;
    private Command command;

    public Router() {
        pathMap = new HashMap<>();
        pathMap.put(0, new HomeCommand());
        pathMap.put(1, new AddStudentInfoCommand());
        pathMap.put(2, new ScoreSheetPrintCommand());
        pathMap.put(3, new ExitCommand());
    }

    public String route(Integer i) {
        command = pathMap.get(i);
        return command.invoke();
    }
}
