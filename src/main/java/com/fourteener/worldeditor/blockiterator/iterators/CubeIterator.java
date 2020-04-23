package com.fourteener.worldeditor.blockiterator.iterators;

import java.util.List;

import org.bukkit.block.Block;

import com.fourteener.worldeditor.blockiterator.BlockIterator;
import com.fourteener.worldeditor.main.GlobalVars;
import com.fourteener.worldeditor.main.Main;

public class CubeIterator extends BlockIterator {

	int x1, y1, z1;
	int x2, y2, z2;
	long totalBlocks;
	long doneBlocks = 0;
	int x, y, z;
	
	@Override
	public CubeIterator newIterator(List<String> args) {
		CubeIterator iterator = new CubeIterator();
		iterator.x1 = Integer.parseInt(args.get(0));
		iterator.y1 = Integer.parseInt(args.get(1));
		iterator.z1 = Integer.parseInt(args.get(2));
		iterator.x2 = Integer.parseInt(args.get(3));
		iterator.y2 = Integer.parseInt(args.get(4));
		iterator.z2 = Integer.parseInt(args.get(5));
		if (iterator.x2 < iterator.x1) {
			int temp = iterator.x1;
			iterator.x1 = iterator.x2;
			iterator.x2 = temp;
		}
		if (iterator.y2 < iterator.y1) {
			int temp = iterator.y1;
			iterator.y1 = iterator.y2;
			iterator.y2 = temp;
		}
		if (iterator.z2 < iterator.z1) {
			int temp = iterator.z1;
			iterator.z1 = iterator.z2;
			iterator.z2 = temp;
		}
		int dx = iterator.x2 - iterator.x1 + 1;
		int dy = iterator.y2 - iterator.y1 + 1;
		int dz = iterator.z2 - iterator.z1 + 1;
		iterator.totalBlocks = dx * dy * dz;
		iterator.x = iterator.x1 - 1;
		iterator.y = iterator.y1;
		iterator.z = iterator.z1;
		Main.logDebug("From " + iterator.x1 + "," + iterator.y1 + "," + iterator.z1 + " to " + iterator.x2 + "," + iterator.y2 + "," + iterator.z2);
		return iterator;
	}

	@Override
	public Block getNext() {
		x++;
		doneBlocks++;
		if (x > x2) {
			z++;
			x = x1;
		}
		if (z > z2) {
			y++;
			z = z1;
		}
		if (y > y2) {
			return null;
		}

		return GlobalVars.world.getBlockAt(x, y, z);
	}

	@Override
	public long getTotalBlocks() {
		return totalBlocks;
	}

	@Override
	public long getRemainingBlocks() {
		return totalBlocks - doneBlocks;
	}

}