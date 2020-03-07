package fourteener.worldeditor.operations.operators.world;

import org.bukkit.Bukkit;

import fourteener.worldeditor.main.*;
import fourteener.worldeditor.operations.Operator;
import fourteener.worldeditor.operations.operators.Node;

public class SetNBTNode extends Node {
	
	String nbt;
	
	public SetNBTNode newNode() {
		SetNBTNode node = new SetNBTNode();
		node.nbt = GlobalVars.operationParser.parseStringNode();
		return node;
	}
	
	public boolean performNode () {
		String command = "data merge block ";
		command += Operator.currentBlock.getLocation().getBlockX() + " ";
		command += Operator.currentBlock.getLocation().getBlockY() + " ";
		command += Operator.currentBlock.getLocation().getBlockZ() + " ";
		command += nbt;
		Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
		return true;
	}
	
	public int getArgCount () {
		return 1;
	}
}