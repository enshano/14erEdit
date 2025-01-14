package com._14ercooper.worldeditor.operations.operators.core;

import com._14ercooper.worldeditor.operations.Operator;

public class ZNode extends NumberNode {

    // Returns a new node
    @Override
    public ZNode newNode() {
	return new ZNode();
    }

    // Return the number
    @Override
    public double getValue() {
	return Operator.currentBlock.getZ();
    }

    // Get how many arguments this type of node takes
    @Override
    public int getArgCount() {
	return 0;
    }

}
