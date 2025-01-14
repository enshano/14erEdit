package com._14ercooper.worldeditor.functions;

import com._14ercooper.worldeditor.functions.commands.logic.CompareSlotCommand;
import com._14ercooper.worldeditor.functions.commands.logic.CompareTextCommand;
import com._14ercooper.worldeditor.functions.commands.logic.CompareVariableCommand;
import com._14ercooper.worldeditor.functions.commands.logic.ExitCommand;
import com._14ercooper.worldeditor.functions.commands.logic.GoIfCommand;
import com._14ercooper.worldeditor.functions.commands.logic.GoIfNotCommand;
import com._14ercooper.worldeditor.functions.commands.logic.ReturnCommand;
import com._14ercooper.worldeditor.functions.commands.logic.WaitCommand;
import com._14ercooper.worldeditor.functions.commands.logic.WaitTimeCommand;
import com._14ercooper.worldeditor.functions.commands.math.AddCommand;
import com._14ercooper.worldeditor.functions.commands.math.CosineCommand;
import com._14ercooper.worldeditor.functions.commands.math.DecrementCommand;
import com._14ercooper.worldeditor.functions.commands.math.DivideCommand;
import com._14ercooper.worldeditor.functions.commands.math.IncrementCommand;
import com._14ercooper.worldeditor.functions.commands.math.ModCommand;
import com._14ercooper.worldeditor.functions.commands.math.MultiplyCommand;
import com._14ercooper.worldeditor.functions.commands.math.PowerCommand;
import com._14ercooper.worldeditor.functions.commands.math.RandCommand;
import com._14ercooper.worldeditor.functions.commands.math.SetVarCommand;
import com._14ercooper.worldeditor.functions.commands.math.SineCommand;
import com._14ercooper.worldeditor.functions.commands.math.SubtractCommand;
import com._14ercooper.worldeditor.functions.commands.player.GetPosCommand;
import com._14ercooper.worldeditor.functions.commands.player.PrintDebugCommand;
import com._14ercooper.worldeditor.functions.commands.player.PrintErrorCommand;
import com._14ercooper.worldeditor.functions.commands.player.SetSlotCommand;
import com._14ercooper.worldeditor.functions.commands.player.SwapCommand;
import com._14ercooper.worldeditor.functions.commands.variable.GetCommand;
import com._14ercooper.worldeditor.functions.commands.variable.RemoveCommand;
import com._14ercooper.worldeditor.functions.commands.variable.StoreCommand;
import com._14ercooper.worldeditor.functions.commands.world.BlockCommand;

public class RegisterFunctions {
    public static void RegisterAll() {
	RegisterPlayer();
	RegisterWorld();
	RegisterLogic();
	RegisterVariable();
	RegisterMath();
    }

    private static void RegisterPlayer() {
	Function.commands.put("prtdbg", new PrintDebugCommand());
	Function.commands.put("prterr", new PrintErrorCommand());
	Function.commands.put("setslot", new SetSlotCommand());
	Function.commands.put("swap", new SwapCommand());
	Function.commands.put("getpos", new GetPosCommand());
    }

    private static void RegisterWorld() {
	Function.commands.put("blk", new BlockCommand());
    }

    private static void RegisterLogic() {
	Function.commands.put("cmpvar", new CompareVariableCommand());
	Function.commands.put("cmptext", new CompareTextCommand());
	Function.commands.put("cmpslot", new CompareSlotCommand());
	Function.commands.put("goif", new GoIfCommand());
	Function.commands.put("goifnot", new GoIfNotCommand());
	Function.commands.put("return", new ReturnCommand());
	Function.commands.put("exit", new ExitCommand());
	Function.commands.put("wait", new WaitCommand());
	Function.commands.put("waittime", new WaitTimeCommand());
    }

    private static void RegisterVariable() {
	Function.commands.put("store", new StoreCommand());
	Function.commands.put("get", new GetCommand());
	Function.commands.put("remove", new RemoveCommand());
    }

    private static void RegisterMath() {
	Function.commands.put("setvar", new SetVarCommand());
	Function.commands.put("rand", new RandCommand());
	Function.commands.put("inc", new IncrementCommand());
	Function.commands.put("dec", new DecrementCommand());
	Function.commands.put("add", new AddCommand());
	Function.commands.put("sub", new SubtractCommand());
	Function.commands.put("mult", new MultiplyCommand());
	Function.commands.put("mod", new ModCommand());
	Function.commands.put("div", new DivideCommand());
	Function.commands.put("sin", new SineCommand());
	Function.commands.put("cos", new CosineCommand());
	Function.commands.put("pow", new PowerCommand());
    }
}
