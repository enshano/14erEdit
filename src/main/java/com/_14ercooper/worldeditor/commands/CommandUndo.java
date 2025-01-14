package com._14ercooper.worldeditor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com._14ercooper.worldeditor.undo.UndoManager;

// These are dedicated versions of the undo and redo commands
public class CommandUndo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if (sender instanceof Player) {
	    if (!((Player) sender).isOp()) {
		sender.sendMessage("You must be opped to use 14erEdit");
		return false;
	    }
	}

	if (sender instanceof Player) {
	    if (command.getName().equalsIgnoreCase("un")) {
		int numToUndo = 1;
		try {
		    numToUndo = Integer.parseInt(args[0]);
		}
		catch (Exception e) {
		    numToUndo = 1;
		}
		return UndoManager.getUndo((Player) sender).undoChanges(numToUndo) > 0;
	    }
	    else if (command.getName().equalsIgnoreCase("re")) {
		int numToRedo = 1;
		try {
		    numToRedo = Integer.parseInt(args[0]);
		}
		catch (Exception e) {
		    numToRedo = 1;
		}
		return UndoManager.getUndo((Player) sender).redoChanges(numToRedo) > 0;
	    }
	    return false;
	}
	return false;
    }
}
