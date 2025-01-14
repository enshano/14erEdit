package com._14ercooper.worldeditor.operations.operators.query;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import com._14ercooper.worldeditor.main.GlobalVars;
import com._14ercooper.worldeditor.main.Main;
import com._14ercooper.worldeditor.operations.Operator;
import com._14ercooper.worldeditor.operations.operators.Node;
import com._14ercooper.worldeditor.operations.operators.function.RangeNode;

public class BlocksAdjacentNode extends Node {

    public Node arg1;
    public RangeNode arg2;

    @Override
    public BlocksAdjacentNode newNode() {
	BlocksAdjacentNode node = new BlocksAdjacentNode();
	try {
	    node.arg2 = GlobalVars.operationParser.parseRangeNode();
	    node.arg1 = GlobalVars.operationParser.parsePart();
	}
	catch (Exception e) {
	    Main.logError("Error creating blocks adjacent node. Please check your syntax.", Operator.currentPlayer);
	    return null;
	}
	if (node.arg2 == null) {
	    Main.logError("Could not parse blocks adjacent node. Two arguments are required, but not given.",
		    Operator.currentPlayer);
	}
	return node;
    }

    @Override
    public boolean performNode() {
	Main.logDebug("Performing faces exposed node"); // -----

	// Check if any adjacent blocks match arg1
	// Set up some variables
	int numAdjacentBlocks = 0;
	Block curBlock = Operator.currentPlayer.getWorld().getBlockAt(Operator.currentBlock.getLocation());

	// Check each direction
	Block blockAdj = curBlock.getRelative(BlockFace.NORTH);
	Operator.currentBlock = blockAdj;
	if (arg1.performNode())
	    numAdjacentBlocks++;
	blockAdj = curBlock.getRelative(BlockFace.SOUTH);
	Operator.currentBlock = blockAdj;
	if (arg1.performNode())
	    numAdjacentBlocks++;
	blockAdj = curBlock.getRelative(BlockFace.EAST);
	Operator.currentBlock = blockAdj;
	if (arg1.performNode())
	    numAdjacentBlocks++;
	blockAdj = curBlock.getRelative(BlockFace.WEST);
	Operator.currentBlock = blockAdj;
	if (arg1.performNode())
	    numAdjacentBlocks++;
	blockAdj = curBlock.getRelative(BlockFace.UP);
	Operator.currentBlock = blockAdj;
	if (arg1.performNode())
	    numAdjacentBlocks++;
	blockAdj = curBlock.getRelative(BlockFace.DOWN);
	Operator.currentBlock = blockAdj;
	if (arg1.performNode())
	    numAdjacentBlocks++;

	// Reset the current block
	Operator.currentBlock = curBlock;

	return (numAdjacentBlocks >= arg2.getMin() - 0.1 && numAdjacentBlocks <= arg2.getMax() + 0.1);
    }

    @Override
    public int getArgCount() {
	return 2;
    }
}
