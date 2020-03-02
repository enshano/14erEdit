package fourteener.worldeditor.operations.operators.query;

import org.bukkit.block.Block;

import fourteener.worldeditor.main.Main;
import fourteener.worldeditor.operations.Operator;
import fourteener.worldeditor.operations.operators.Node;
import fourteener.worldeditor.operations.operators.function.RangeNode;

public class BlocksAboveNode extends Node {
	
	RangeNode arg1;
	Node arg2;
	
	public BlocksAboveNode(RangeNode range, Node block) {
		arg1 = range;
		arg2 = block;
	}
	
	public boolean performNode () {
		Block currBlock = Main.world.getBlockAt(Operator.currentBlock.getLocation());
		int x = currBlock.getX();
		int y = currBlock.getY();
		int z = currBlock.getZ();
		int min = (int) arg1.getMin();
		int max = (int) arg1.getMax();
		boolean blockRangeMet = true;
		
		for (int dy = y + min; dy <= y + max; dy++) {
			Operator.currentBlock = Main.world.getBlockAt(x, dy, z).getState();
			if (!(arg2.performNode()))
				blockRangeMet = false;
		}
		
		Operator.currentBlock = currBlock.getState();
		return blockRangeMet;
	}
	
	public static int getArgCount () {
		return 2;
	}
}
