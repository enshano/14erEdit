package fourteener.worldeditor.worldeditor.scripts.bundled;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import fourteener.worldeditor.worldeditor.scripts.Craftscript;

public class ScriptErode extends Craftscript {

	@Override
	public List<BlockState> perform(LinkedList<String> args, Player player) {
		String radius = args.get(0);
		String modeArg = args.get(1);
		String mode = "";
		if (modeArg.equalsIgnoreCase("cut") || modeArg.equalsIgnoreCase("raise") || modeArg.equalsIgnoreCase("smmoth")) {
			mode = "melt";
		}
		player.performCommand("fx br s 0 0.5 $ erode{" + radius + "," + mode + "," + modeArg + "}");
		return null;
	}

}
