package com.fourteener.worldeditor.scripts.bundled.easyedit;

import java.util.LinkedList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.fourteener.worldeditor.main.*;
import com.fourteener.worldeditor.scripts.Craftscript;

public class ScriptLine extends Craftscript {

	// Args block depth air
	@Override
	public boolean perform(LinkedList<String> args, Player player, String label) {
		String block = args.get(0);
		int length;
		if (args.size() > 1) {
			length = Integer.parseInt(args.get(1));
		}
		else {
			length = Integer.MAX_VALUE;
		}
		Material mat = Material.matchMaterial(block);
		
		for (int i = 1; i < length; i++) {
			Vector blockPos = player.getLocation().getDirection();
			Vector playerPos = player.getLocation().toVector();
			blockPos.setX(blockPos.getX() * i + playerPos.getX());
			blockPos.setY(blockPos.getY() * i + playerPos.getY() + 1);
			blockPos.setZ(blockPos.getZ() * i + playerPos.getZ());
			
			Block b = GlobalVars.world.getBlockAt(blockPos.getBlockX(), blockPos.getBlockY(), blockPos.getBlockZ());
			
			if (b.getType() != Material.AIR && b.getType() != mat) {
				break;
			}
			SetBlock.setMaterial(b, mat);
		}
		
		return true;
	}
}