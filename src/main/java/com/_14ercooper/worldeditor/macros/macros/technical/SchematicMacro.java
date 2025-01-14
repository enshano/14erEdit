package com._14ercooper.worldeditor.macros.macros.technical;

import org.bukkit.Location;

import com._14ercooper.worldeditor.macros.macros.Macro;
import com._14ercooper.worldeditor.main.GlobalVars;
import com._14ercooper.worldeditor.operations.Operator;
import com._14ercooper.worldeditor.selection.SchematicHandler;

public class SchematicMacro extends Macro {

    String path = "";
    int xPos = 0, yPos = 0, zPos = 0;
    boolean setAir = false;
    String mirrorOpts = "";
    int executionOrder = 0;

    // Create a new macro
    private void SetupMacro(String[] args, Location loc) {
	// Parse the file path
	path = args[0];
	// Parse the offset
	int xOff = 1, yOff = 1, zOff = 1;
	try {
	    xOff = Integer.parseInt(args[1]);
	}
	catch (NumberFormatException e) {
	    xOff = Integer.MAX_VALUE;
	}
	try {
	    yOff = Integer.parseInt(args[2]);
	}
	catch (NumberFormatException e) {
	    yOff = Integer.MAX_VALUE;
	}
	try {
	    zOff = Integer.parseInt(args[3]);
	}
	catch (NumberFormatException e) {
	    zOff = Integer.MAX_VALUE;
	}
	xPos = loc.getBlockX() + xOff;
	yPos = loc.getBlockY() + yOff;
	zPos = loc.getBlockZ() + zOff;
	// Parse setting air
	setAir = Boolean.parseBoolean(args[4]);
	// Parse the mirrorString
	if (args.length > 5)
	    mirrorOpts = args[5];
	if (args.length > 6)
	    executionOrder = Integer.parseInt(args[6]);
    } // /fx br v macro schem{jungle_1;c;0;c;false;r}

    // Run this macro
    @Override
    public boolean performMacro(String[] args, Location loc) {
	SetupMacro(args, loc);
	int[] origin = { xPos, yPos, zPos };
	String[] schemNames = path.split("\\|");
	String useSchem = schemNames[GlobalVars.rand.nextInt(schemNames.length)];
	if (mirrorOpts.contains("r")) {
	    mirrorOpts = "t";
	    if (GlobalVars.rand.nextBoolean()) {
		mirrorOpts = mirrorOpts + "x";
	    }
	    if (GlobalVars.rand.nextBoolean()) {
		mirrorOpts = mirrorOpts + "z";
	    }
	}
	return SchematicHandler.loadSchematic(useSchem, origin, mirrorOpts, setAir, Operator.currentPlayer,
		executionOrder, loc);
    }
}
