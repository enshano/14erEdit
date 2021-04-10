package com._14ercooper.worldeditor.functions.commands.math;

import java.util.List;

import com._14ercooper.worldeditor.functions.Function;
import com._14ercooper.worldeditor.functions.commands.InterpreterCommand;

public class RoundCommand extends InterpreterCommand {

    @Override
    public void run(List<String> args, Function function) {
        function.setVariable(args.get(0), Math.round(function.parseVariable(args.get(0))));
    }
}
