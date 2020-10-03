package com._14ercooper.worldeditor.blockiterator;

import com._14ercooper.worldeditor.blockiterator.iterators.*;
import com._14ercooper.worldeditor.main.GlobalVars;

public class IteratorLoader {
    public static void LoadIterators() {
	GlobalVars.iteratorManager.addIterator("cube", new CubeIterator());
	GlobalVars.iteratorManager.addIterator("sphere", new SphereIterator());
	GlobalVars.iteratorManager.addIterator("cylinder", new CylinderIterator());
	GlobalVars.iteratorManager.addIterator("ellipse", new EllipseIterator());
	GlobalVars.iteratorManager.addIterator("diamond", new DiamondIterator());
	GlobalVars.iteratorManager.addIterator("multi", new MultiIterator());
	GlobalVars.iteratorManager.addIterator("schem", new SchemBrushIterator());
	GlobalVars.iteratorManager.addIterator("newcylinder", new SchemBrushIterator());
	GlobalVars.iteratorManager.addIterator("rotatedellipse", new SchemBrushIterator());
	GlobalVars.iteratorManager.addIterator("spike", new SchemBrushIterator());
    }
}
