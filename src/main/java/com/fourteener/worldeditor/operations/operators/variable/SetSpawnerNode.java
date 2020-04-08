package com.fourteener.worldeditor.operations.operators.variable;

import com.fourteener.worldeditor.main.*;
import com.fourteener.worldeditor.operations.Operator;
import com.fourteener.worldeditor.operations.operators.Node;
import com.fourteener.worldeditor.operations.type.SpawnerVar;

public class SetSpawnerNode extends Node {
	
	String name;
	
	public SetSpawnerNode newNode() {
		SetSpawnerNode node = new SetSpawnerNode();
		node.name = GlobalVars.operationParser.parseStringNode();
		return node;
	}
	
	public boolean performNode () {
		SpawnerVar var = Operator.spawnerVars.get(name);
		GlobalVars.currentUndo.storeBlock(Operator.currentBlock);
		String command = "setblock " + Operator.currentBlock.getX();
		command += " " + Operator.currentBlock.getY();
		command += " " + Operator.currentBlock.getZ();
		command += " minecraft:spawner";
		command += var.getNBT();
		command += " replace";
		Main.logDebug("Command: " + command);
		Operator.currentPlayer.performCommand(command);
		return true;
	}
	
	public int getArgCount () {
		return 1;
	}
}