package com._14ercooper.worldeditor.operations.operators.core;

import com._14ercooper.worldeditor.operations.Operator;

public class XNode extends NumberNode {

    // Returns a new node
    @Override
    public XNode newNode() {
	return new XNode();
    }

    // Return the number
    @Override
    public double getValue() {
	return Operator.currentBlock.getX();
    }

    // Get how many arguments this type of node takes
    @Override
    public int getArgCount() {
	return 0;
    }

}
