package fourteener.worldeditor.operations.operators.loop;

import fourteener.worldeditor.main.*;
import fourteener.worldeditor.operations.Operator;
import fourteener.worldeditor.operations.operators.Node;
import fourteener.worldeditor.operations.operators.core.NumberNode;

public class NumericEqualityNode extends Node {
	
	public String name;
	public NumberNode val;
	
	public NumericEqualityNode newNode() {
		NumericEqualityNode node = new NumericEqualityNode();
		node.name = GlobalVars.operationParser.parseStringNode();
		node.val = GlobalVars.operationParser.parseNumberNode();
		return node;
	}
	
	public boolean performNode () {
		return (Math.abs(Operator.numericVars.get(name).getValue() - val.getValue()) < 0.01);
	}
	
	public int getArgCount () {
		return 2;
	}
}
