package fourteener.worldeditor.operations.operators.world;

import org.bukkit.Material;

import fourteener.worldeditor.operations.Operator;

public class SameNode extends BlockNode {
	
	public SameNode() {
		return;
	}
	
	public boolean performNode () {
		return true;
	}
	
	public Material getBlock () {
		return Operator.currentBlock.getType();
	}
	
	public static int getArgCount () {
		return 0;
	}

}
