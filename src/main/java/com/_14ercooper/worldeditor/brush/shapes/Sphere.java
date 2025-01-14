package com._14ercooper.worldeditor.brush.shapes;

import java.util.ArrayList;
import java.util.List;

import com._14ercooper.worldeditor.blockiterator.BlockIterator;
import com._14ercooper.worldeditor.brush.BrushShape;
import com._14ercooper.worldeditor.main.GlobalVars;

public class Sphere extends BrushShape {

    String radius = "";
    String correction = "0.5";
    int numArgsProcessed = 0;

    @Override
    public BlockIterator GetBlocks(double x, double y, double z) {
	List<String> argList = new ArrayList<String>();
	argList.add(Integer.toString((int) x));
	argList.add(Integer.toString((int) y));
	argList.add(Integer.toString((int) z));
	argList.add(radius);
	argList.add(Integer.toString(0));
	argList.add(correction);
	return GlobalVars.iteratorManager.getIterator("sphere").newIterator(argList);
    }

    @Override
    public void addNewArgument(String argument) {
	if (numArgsProcessed == 0) {
	    radius = argument;
	}
	else if (numArgsProcessed == 1) {
	    try {
		Double.parseDouble(argument);
		correction = argument;
	    }
	    catch (NumberFormatException e) {
		// This isn't a number, so start the operation parser
		numArgsProcessed++;
	    }
	}
	numArgsProcessed++;
    }

    @Override
    public boolean lastInputProcessed() {
	return numArgsProcessed < 3;
    }

    @Override
    public boolean gotEnoughArgs() {
	return numArgsProcessed > 0;
    }

}
