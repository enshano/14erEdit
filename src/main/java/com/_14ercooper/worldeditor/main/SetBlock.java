package com._14ercooper.worldeditor.main;

import com._14ercooper.worldeditor.async.AsyncManager;
import com._14ercooper.worldeditor.operations.Operator;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Leaves;

public class SetBlock {
    public static void setMaterial(Block b, Material mat) {
        if (GlobalVars.countEdits) {
            ++AsyncManager.doneOperations;
        }
        if (Main.inEditRegion(b.getX(), b.getY(), b.getZ())) {
            return;
        }
        try {
            if (GlobalVars.currentUndo != null)
                GlobalVars.currentUndo.storeBlock(b);
            b.setType(mat, false);
            if (mat.toString().toLowerCase().contains("leaves")) {
                Leaves leafData = (Leaves) b.getBlockData();
                leafData.setPersistent(true);
                b.setBlockData(leafData);
            }
        } catch (Exception e) {
            GlobalVars.asyncManager.dropAsync();
            if (mat == null) {
                Main.logError("Invalid block ID NULL provided. The async queue has been dropped.",
                        Operator.currentPlayer, e);
            }
            Main.logError("Invalid block ID " + mat == null ? "NULL" : mat.toString() + " provided. The async queue has been dropped.",
                    Operator.currentPlayer, e);
//	    e.printStackTrace();
        }
    }

    public static void setMaterial(Block b, Material mat, boolean physics) {
        if (GlobalVars.countEdits) {
            ++AsyncManager.doneOperations;
        }
        if (Main.inEditRegion(b.getX(), b.getY(), b.getZ())) {
            return;
        }
        try {
            if (GlobalVars.currentUndo != null)
                GlobalVars.currentUndo.storeBlock(b);
            b.setType(mat, physics);
            if (mat.toString().toLowerCase().contains("leaves")) {
                Leaves leafData = (Leaves) b.getBlockData();
                leafData.setPersistent(true);
                b.setBlockData(leafData);
            }
        } catch (Exception e) {
            GlobalVars.asyncManager.dropAsync();
            if (mat == null) {
                Main.logError("Invalid block ID NULL provided. The async queue has been dropped.",
                        Operator.currentPlayer, e);
            }
            Main.logError("Invalid block ID " + mat == null ? "NULL" : mat.toString() + " provided. The async queue has been dropped.",
                    Operator.currentPlayer, e);
//	    e.printStackTrace();
        }
    }

    public static void setMaterial(BlockState b, Material mat) {
        if (GlobalVars.countEdits) {
            ++AsyncManager.doneOperations;
        }
        if (Main.inEditRegion(b.getX(), b.getY(), b.getZ())) {
            return;
        }
        try {
            if (GlobalVars.currentUndo != null)
                GlobalVars.currentUndo.storeBlock(b.getBlock());
            b.setType(mat);
            if (mat.toString().toLowerCase().contains("leaves")) {
                Leaves leafData = (Leaves) b.getBlockData();
                leafData.setPersistent(true);
                b.setBlockData(leafData);
            }
        } catch (Exception e) {
            GlobalVars.asyncManager.dropAsync();
            if (mat == null) {
                Main.logError("Invalid block ID NULL provided. The async queue has been dropped.",
                        Operator.currentPlayer, e);
            }
            Main.logError("Invalid block ID " + mat == null ? "NULL" : mat.toString() + " provided. The async queue has been dropped.",
                    Operator.currentPlayer, e);
//	    e.printStackTrace();
        }
    }
}
