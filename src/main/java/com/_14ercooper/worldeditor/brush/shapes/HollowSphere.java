package com._14ercooper.worldeditor.brush.shapes;

import java.util.ArrayList;
import java.util.List;

import com._14ercooper.worldeditor.blockiterator.BlockIterator;
import com._14ercooper.worldeditor.brush.BrushShape;
import com._14ercooper.worldeditor.main.GlobalVars;

public class HollowSphere extends BrushShape {

    String radius, innerRadius, correction = "0.5";
    int argsSeen = 0;

    @Override
    public BlockIterator GetBlocks(double x, double y, double z) {
	List<String> argList = new ArrayList<String>();
	argList.add(Integer.toString((int) x));
	argList.add(Integer.toString((int) y));
	argList.add(Integer.toString((int) z));
	argList.add(radius);
	argList.add(innerRadius);
	argList.add(correction);
	return GlobalVars.iteratorManager.getIterator("sphere").newIterator(argList);
    }

    @Override
    public void addNewArgument(String argument) {
	if (argsSeen == 0) {
	    Integer.parseInt(argument);
	    radius = argument;
	}
	if (argsSeen == 1) {
	    Integer.parseInt(argument);
	    innerRadius = argument;
	}
	if (argsSeen == 2) {
	    try {
		Double.parseDouble(argument);
		correction = argument;
	    }
	    catch (NumberFormatException e) {
		argsSeen++;
	    }
	}
	argsSeen++;
    }

    @Override
    public boolean lastInputProcessed() {
	return argsSeen < 4;
    }

    @Override
    public boolean gotEnoughArgs() {
	return argsSeen > 1;
    }

}
