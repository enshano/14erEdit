package com._14ercooper.worldeditor.selection;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com._14ercooper.schematics.SchemLite;
import com._14ercooper.worldeditor.main.GlobalVars;
import com._14ercooper.worldeditor.main.Main;
import com._14ercooper.worldeditor.operations.Operator;

public class SchematicHandler {
    // Save a schematic to disk
    public static boolean saveSchematic(String file, Player p) {
	Main.logDebug("Saving schematic to " + file);
	Operator.currentPlayer = p;
	SelectionManager sm = SelectionManager.getSelectionManager(p);
	double[] rawOrigin = sm.getMostNegativeCorner();
	double[] posCorner = sm.getMostPositiveCorner();
	int[] origin = { (int) rawOrigin[0], (int) rawOrigin[1], (int) rawOrigin[2] };
	int xSize = (int) Math.abs(posCorner[0] - rawOrigin[0] + 1);
	int ySize = (int) Math.abs(posCorner[1] - rawOrigin[1] + 1);
	int zSize = (int) Math.abs(posCorner[2] - rawOrigin[2] + 1);
	String path = file;
	String author = p.getDisplayName();
	String date = (new SimpleDateFormat("yyyy-mm-dd")).format(Calendar.getInstance().getTime());
	SchemLite schem = new SchemLite(xSize, ySize, zSize, path, author, date);
	try {
	    schem.resetWrite();
	}
	catch (IOException e) {
	    Main.logError("Could not write to schematic file.", p);
	}
	GlobalVars.asyncManager.scheduleEdit(schem, true, p, origin);
	return true;
    }

    // Load a schematic into the world
    public static boolean loadSchematic(String file, Player p, String mirror, boolean setAir, int executionOrder) {
	Main.logDebug("Loading schematic from " + file);
	Operator.currentPlayer = p;
	int[] origin = { p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ() };
	String path = file;
	SchemLite schem = new SchemLite(path, setAir, executionOrder);
	Main.logDebug("Execution order " + executionOrder);
	try {
	    schem.openRead();
	}
	catch (IOException e) {
	    Main.logError("Could not load schematic. File " + file + " not found.", p);
	}
	if (!mirror.isEmpty()) {
	    schem.mirror(mirror.contains("x"), mirror.contains("y"), mirror.contains("z"));
	}
	GlobalVars.asyncManager.scheduleEdit(schem, false, p, origin);
	return true;
    }

    // Load a schematic into the world with offset
    public static boolean loadSchematic(String file, Player p, String mirror, boolean setAir, int[] offset,
	    int executionOrder) {
	Main.logDebug("Loading schematic from " + file);
	Operator.currentPlayer = p;
	int[] origin = { p.getLocation().getBlockX() + offset[0], p.getLocation().getBlockY() + offset[1],
		p.getLocation().getBlockZ() + offset[2] };
	String path = file;
	SchemLite schem = new SchemLite(path, setAir, executionOrder);
	Main.logDebug("Execution order " + executionOrder);
	try {
	    schem.openRead();
	}
	catch (IOException e) {
	    Main.logError("Could not load schematic. File " + file + " not found.", p);
	}
	if (!mirror.isEmpty()) {
	    schem.mirror(mirror.contains("x"), mirror.contains("y"), mirror.contains("z"));
	}
	GlobalVars.asyncManager.scheduleEdit(schem, false, p, origin);
	return true;
    }

    // Load a schematic into the world at position
    public static boolean loadSchematic(String file, int[] origin, String mirror, boolean setAir, Player p,
	    int executionOrder) {
	Main.logDebug("Loading schematic from " + file);
	Operator.currentPlayer = p;
	String path = file;
	SchemLite schem = new SchemLite(path, setAir, executionOrder);
	Main.logDebug("Execution order " + executionOrder);
	try {
	    schem.openRead();
	}
	catch (IOException e) {
	    Main.logError("Could not load schematic. File " + file + " not found.", p);
	}
//	if (bigValue(origin[0])) {
//	    Main.logDebug("Schematic center x not number. Using autocenter.");
//	    origin[0] = -1 * (schem.getXSize() / 2);
//	}
//	if (bigValue(origin[1])) {
//	    Main.logDebug("Schematic center y not number. Using autocenter.");
//	    origin[0] = -1 * (schem.getYSize() / 2);
//	}
//	if (bigValue(origin[2])) {
//	    Main.logDebug("Schematic center z not number. Using autocenter.");
//	    origin[0] = -1 * (schem.getZSize() / 2);
//	}
	if (!mirror.isEmpty()) {
	    schem.mirror(mirror.contains("x"), mirror.contains("y"), mirror.contains("z"));
	}
	GlobalVars.asyncManager.scheduleEdit(schem, false, p, origin);
	return true;
    }

    // Load a schematic into the world at position
    public static boolean loadSchematic(String file, int[] origin, String mirror, boolean setAir, Player p,
	    int executionOrder, Location loc) {
	Main.logDebug("Loading schematic from " + file);
	Operator.currentPlayer = p;
	String path = file;
	SchemLite schem = new SchemLite(path, setAir, executionOrder);
	Main.logDebug("Execution order " + executionOrder);
	try {
	    schem.openRead();
	}
	catch (IOException e) {
	    Main.logError("Could not load schematic. File " + file + " not found.", p);
	}
	if (bigValue(origin[0])) {
	    Main.logDebug("Schematic center x not number. Using autocenter.");
	    origin[0] = -1 * (schem.getXSize() / 2);
	    origin[0] += loc.getBlockX();
	}
	if (bigValue(origin[1])) {
	    Main.logDebug("Schematic center y not number. Using autocenter.");
	    origin[1] = -1 * (schem.getYSize() / 2);
	    origin[1] += loc.getBlockY();
	}
	if (bigValue(origin[2])) {
	    Main.logDebug("Schematic center z not number. Using autocenter.");
	    origin[2] = -1 * (schem.getZSize() / 2);
	    origin[2] += loc.getBlockZ();
	}
	if (!mirror.isEmpty()) {
	    schem.mirror(mirror.contains("x"), mirror.contains("y"), mirror.contains("z"));
	}
	GlobalVars.asyncManager.scheduleEdit(schem, false, p, origin);
	return true;
    }

    public static boolean bigValue(int num) {
	return Math.abs(num) > Integer.MAX_VALUE / 2;
    }
}
