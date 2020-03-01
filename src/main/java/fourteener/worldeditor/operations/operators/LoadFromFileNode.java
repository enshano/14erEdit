package fourteener.worldeditor.operations.operators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fourteener.worldeditor.main.Main;
import fourteener.worldeditor.operations.Operator;

public class LoadFromFileNode extends Node {
	
	String path;
	
	public static LoadFromFileNode newNode (String filename) {
		LoadFromFileNode node = new LoadFromFileNode();
		node.path = filename;
		return node;
	}
	
	public boolean performNode () {
		if (!Operator.fileLoads.containsKey(path)) {
			List<String> lines = new ArrayList<String>();
			try {
				lines = Files.readAllLines(Paths.get(("plugins/14erEdit/ops/" + path).replace("/", File.separator)));
			} catch (IOException e) {
				Main.logDebug("Issue opening file");
			}
			List<String> newOperators = new ArrayList<String>();
			for (String s : lines) {
				String[] strArr = s.split("\\s+");
				for (String str : strArr) {
					newOperators.add(str);
				}
				
			}
			String toParse = "";
			for (String s : newOperators) {
				toParse += s + " ";
			}
			Operator o = Operator.newOperator(toParse);
			Operator.fileLoads.put(path, o);
		}
		Operator o = Operator.fileLoads.get(path);
		return o.messyOperate();
	}
	
	public static int getArgCount () {
		return 1;
	}
}