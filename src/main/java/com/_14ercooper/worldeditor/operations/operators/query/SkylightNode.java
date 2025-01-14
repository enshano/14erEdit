package com._14ercooper.worldeditor.operations.operators.query;

import org.bukkit.block.BlockFace;

import com._14ercooper.worldeditor.main.GlobalVars;
import com._14ercooper.worldeditor.operations.Operator;
import com._14ercooper.worldeditor.operations.operators.Node;
import com._14ercooper.worldeditor.operations.operators.core.NumberNode;

public class SkylightNode extends Node {

    NumberNode arg;

    @Override
    public SkylightNode newNode() {
	SkylightNode node = new SkylightNode();
	node.arg = GlobalVars.operationParser.parseNumberNode();
	return node;
    }

    @Override
    public boolean performNode() {
	BlockFace[] faces = { BlockFace.UP, BlockFace.DOWN, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST,
		BlockFace.WEST };
	int light = Operator.currentBlock.getLightFromSky();
	for (BlockFace face : faces) {
	    int l = Operator.currentBlock.getRelative(face).getLightFromSky();
	    if (l > light)
		light = l;
	}
	return light >= arg.getValue();
    }

    @Override
    public int getArgCount() {
	return 1;
    }

}
