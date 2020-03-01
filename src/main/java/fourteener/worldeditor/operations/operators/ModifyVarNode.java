package fourteener.worldeditor.operations.operators;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fourteener.worldeditor.operations.Operator;
import fourteener.worldeditor.operations.type.BlockVar;
import fourteener.worldeditor.operations.type.ColorText;
import fourteener.worldeditor.operations.type.ItemVar;
import fourteener.worldeditor.operations.type.NumericVar;

public class ModifyVarNode extends Node {
	
	String type, name;
	List<String> mod;
	
	public static ModifyVarNode newNode (String arg1, String arg2, String arg3) {
		ModifyVarNode node = new ModifyVarNode();
		node.type = arg1;
		node.name = arg2;
		node.mod = Arrays.asList(arg3.split(","));
		return node;
	}
	
	public boolean performNode () {
		// Modify a numeric
		if (type.equalsIgnoreCase("num")) {
			// Set mod
			if (mod.get(0).equalsIgnoreCase("set")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(Integer.parseInt(mod.get(1)));
				Operator.numericVars.put(name, var);
				return true;
			}
			// Increment by 1 mod
			if (mod.get(0).equalsIgnoreCase("+")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(var.getValue() + 1);
				Operator.numericVars.put(name, var);
				return true;
			}
			// Increment mod
			if (mod.get(0).equalsIgnoreCase("inc")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(var.getValue() + Integer.parseInt(mod.get(1)));
				Operator.numericVars.put(name, var);
				return true;
			}
			// Multiply mod
			if (mod.get(0).equalsIgnoreCase("mult")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(var.getValue() * Integer.parseInt(mod.get(1)));
				Operator.numericVars.put(name, var);
				return true;
			}
			// Power mod
			if (mod.get(0).equalsIgnoreCase("pow")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(Math.pow(var.getValue(), Integer.parseInt(mod.get(1))));
				Operator.numericVars.put(name, var);
				return true;
			}
			// Exponent mod
			if (mod.get(0).equalsIgnoreCase("exp")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(Math.pow(Integer.parseInt(mod.get(1)), var.getValue()));
				Operator.numericVars.put(name, var);
				return true;
			}
			// Truncate mod
			if (mod.get(0).equalsIgnoreCase("trn")) {
				NumericVar var = Operator.numericVars.get(name);
				var.setValue(Math.floor(var.getValue()));
				Operator.numericVars.put(name, var);
				return true;
			}
			
			return false;
		}
		
		// Modify a block
		if (type.equalsIgnoreCase("blk")) {
			// Type mod
			if (mod.get(0).equalsIgnoreCase("type")) {
				BlockVar var = Operator.blockVars.get(name);
				var.setType(mod.get(1));
				Operator.blockVars.put(name, var);
				return true;
			}
			// Data mod
			if (mod.get(0).equalsIgnoreCase("data")) {
				BlockVar var = Operator.blockVars.get(name);
				var.setData(mod.get(1));
				Operator.blockVars.put(name, var);
				return true;
			}
			// NBT mod
			if (mod.get(0).equalsIgnoreCase("nbt")) {
				BlockVar var = Operator.blockVars.get(name);
				var.setNbt(mod.get(1));
				Operator.blockVars.put(name, var);
				return true;
			}
			
			return false;
		}
		
		// Modify an item
		if (type.equalsIgnoreCase("itm")) {
			// Type mod
			if (mod.get(0).equalsIgnoreCase("type")) {
				ItemVar var = Operator.itemVars.get(name);
				var.setType(mod.get(1));
				Operator.itemVars.put(name, var);
				return true;
			}
			// Name mod
			if (mod.get(0).equalsIgnoreCase("name")) {
				if (mod.get(1).equalsIgnoreCase("color")) {
					ItemVar var = Operator.itemVars.get(name);
					ColorText ct = new ColorText(mod.get(2), mod.get(3));
					if (mod.size() > 4) {
						ct.setBold(mod.get(4));
					}
					if (mod.size() > 5) {
						ct.setItalic(mod.get(5));
					}
					if (mod.size() > 6) {
						ct.setUnderlined(mod.get(6));
					}
					if (mod.size() > 7) {
						ct.setStrikethrough(mod.get(7));
					}
					if (mod.size() > 8) {
						ct.setObfuscated(mod.get(8));
					}
					var.setName(ct);
					Operator.itemVars.put(name, var);
				}
				else {
					ItemVar var = Operator.itemVars.get(name);
					var.setName(new ColorText(mod.get(1)));
					Operator.itemVars.put(name, var);
				}
				return true;
			}
			// Lore mod
			if (mod.get(0).equalsIgnoreCase("lore")) {
				ItemVar var = Operator.itemVars.get(name);
				List<ColorText> ls = var.getLore();
				if (mod.get(1).equalsIgnoreCase("color")) {
					ColorText ct = new ColorText(mod.get(2), mod.get(3));
					if (mod.size() > 4) {
						ct.setBold(mod.get(4));
					}
					if (mod.size() > 5) {
						ct.setItalic(mod.get(5));
					}
					if (mod.size() > 6) {
						ct.setUnderlined(mod.get(6));
					}
					if (mod.size() > 7) {
						ct.setStrikethrough(mod.get(7));
					}
					if (mod.size() > 8) {
						ct.setObfuscated(mod.get(8));
					}
					ls.add(ct);
				}
				else {
					ls.add(new ColorText(mod.get(1)));
				}
				var.setLore(ls);
				Operator.itemVars.put(name, var);
				return true;
			}
			// Enchant mod
			if (mod.get(0).equalsIgnoreCase("ench")) {
				ItemVar var = Operator.itemVars.get(name);
				Map<String, Integer> mp = var.getEnchants();
				mp.put(mod.get(1), Integer.parseInt(mod.get(2)));
				var.setEnchants(mp);
				Operator.itemVars.put(name, var);
				return true;
			}
			// Attribute mod
			if (mod.get(0).equalsIgnoreCase("attr")) {
				ItemVar var = Operator.itemVars.get(name);
				Map<String, String> mp = var.getAttributes();
				mp.put(mod.get(1), mod.get(2) + "," + mod.get(3) + "," + mod.get(4));
				var.setAttributes(mp);
				Operator.itemVars.put(name, var);
				return true;
			}
			// Count mod
			if (mod.get(0).equalsIgnoreCase("cnt")) {
				ItemVar var = Operator.itemVars.get(name);
				var.setCount(Integer.parseInt(mod.get(1)));
				Operator.itemVars.put(name, var);
				return true;
			}
			// Damage mod
			if (mod.get(0).equalsIgnoreCase("dmg")) {
				ItemVar var = Operator.itemVars.get(name);
				var.setDamage(Integer.parseInt(mod.get(1)));
				Operator.itemVars.put(name, var);
				return true;
			}
			// Flag mod
			if (mod.get(0).equalsIgnoreCase("flag")) {
				ItemVar var = Operator.itemVars.get(name);
				var.setFlags(Integer.parseInt(mod.get(1)));
				Operator.itemVars.put(name, var);
				return true;
			}
			// Unbreakable mod
			if (mod.get(0).equalsIgnoreCase("unbreak")) {
				ItemVar var = Operator.itemVars.get(name);
				if (mod.get(1).equalsIgnoreCase("true")) {
					var.setUnbreakable(true);
				}
				else if (mod.get(1).equalsIgnoreCase("false")) {
					var.setUnbreakable(false);
				}
				Operator.itemVars.put(name, var);
				return true;
			}
			
			return false;
		}
		
		// Invalid type
		return false;
	}
	
	public static int getArgCount () {
		return 3;
	}
}
