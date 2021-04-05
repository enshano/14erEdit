package com._14ercooper.worldeditor.operations.operators.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com._14ercooper.worldeditor.main.GlobalVars;
import com._14ercooper.worldeditor.main.Main;
import com._14ercooper.worldeditor.operations.Operator;
import com._14ercooper.worldeditor.operations.operators.Node;

public class CheckBiomeNode extends Node {

    List<String> biomes = new ArrayList<String>();

    @Override
    public Node newNode() {
	try {
	    CheckBiomeNode node = new CheckBiomeNode();
	    node.biomes.addAll(Arrays.asList(GlobalVars.operationParser.parseStringNode().getText().split(",")));
	    if (node.biomes == null) {
		Main.logError("Could not parse set biome node. Did you provide a biome?", Operator.currentPlayer);
	    }
	    return node;
	}
	catch (Exception e) {
	    Main.logError("Error parisng biome node. Please check your syntax.", Operator.currentPlayer);
	    return null;
	}
    }

    @Override
    public boolean performNode() {
	try {
	    String currBiome = Operator.currentBlock.getBiome().toString();
	    for (String s : biomes) {
		if (currBiome.equalsIgnoreCase(s))
		    return true;
	    }
	    return false;
	}
	catch (Exception e) {
	    Main.logError("Error perfoming check biome node. Did you provide valid biomes?", Operator.currentPlayer);
	    return false;
	}
    }

    @Override
    public int getArgCount() {
	return 1;
    }

}
