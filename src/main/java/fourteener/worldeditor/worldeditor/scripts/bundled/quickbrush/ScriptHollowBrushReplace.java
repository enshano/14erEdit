package fourteener.worldeditor.worldeditor.scripts.bundled.quickbrush;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import fourteener.worldeditor.worldeditor.scripts.Craftscript;

public class ScriptHollowBrushReplace extends Craftscript {

	@Override
	public List<BlockState> perform(LinkedList<String> args, Player player, String label) {
		String brushRadius = args.get(0);
		String thickness = args.get(1);
		String blocksToReplace = args.get(2);
		String[] replaceIndividual = blocksToReplace.split(",");
		String blocksToSet = args.get(1);
		String[] individualBlocks = blocksToSet.split(",");
		String opToRun = "";
		
		// This section parses the mask portion of the command
		if (replaceIndividual.length == 1) {
			opToRun = "? " + replaceIndividual[0] + " ";
		}
		else {
			int numOr = replaceIndividual.length - 1;
			opToRun = "? ";
			for (int i = 0; i < numOr; i++) {
				opToRun = opToRun.concat("| ");
			}
			for (String s : replaceIndividual) {
				opToRun = opToRun.concat(s) + " ";
			}
		}
		
		// This section parses the setting portion of the command
		if (individualBlocks.length == 1) {
			// Parse if it needs block data
			if (individualBlocks[0].contains("[")) {
				opToRun = opToRun.concat(">> ");
				if (individualBlocks[0].contains("mineacraft:")) {
					opToRun = opToRun.concat(individualBlocks[0]);
				}
				else {
					opToRun = opToRun.concat("minecraft:");
					opToRun = opToRun.concat(individualBlocks[0]);
					}
			}
			// Parse if no block data
			else {
				opToRun = opToRun.concat("> ") + individualBlocks[0];
			}
		}
		else {
			// First calculate the odds
			List<Double> oddsList = new ArrayList<Double>();
			double oddsRemaining = 1.0;
			for (String s : individualBlocks) {
				Double oddsToUse = Double.parseDouble(s.split("%")[0]);
				oddsList.add(oddsToUse / oddsRemaining);
				oddsRemaining -= (oddsToUse / 100.0);
			}
			// Then construct the operation
			for (int i = 0; i < individualBlocks.length; i++) {
				opToRun = opToRun.concat("? % " + oddsList.get(i) + " ");
				String parsedBlock = "", parseText = individualBlocks[i].split("%")[1];
				// Parse if it needs block data
				if (parseText.contains("[")) {
					parsedBlock = ">> ";
					if (parseText.contains("mineacraft:")) {
						parsedBlock = parsedBlock.concat(parseText);
					}
					else {
						parsedBlock = parsedBlock.concat("minecraft:");
						parsedBlock = parsedBlock.concat(parseText);
						}
				}
				// Parse if no block data
				else {
					parsedBlock = "> " + parseText;
				}
				// Add to the operator
				opToRun = opToRun.concat(parsedBlock + " ");
			}
			opToRun = opToRun.concat("false");
		}
		opToRun = opToRun.concat(" false");
		
		// Perform the replace command
		player.performCommand("fx br hsphere " + brushRadius + " " + thickness + " 0.5 " + opToRun);
		return null;
	}
}
