package fourteener.worldeditor.math;

public class Vector {
	
	private double[] contents;
	
	public Vector (double x, double y, double z, double w) {
		double[] temp = {x, y, z, w};
		contents = temp;
	}
	
	public Vector (double[] xyzw) {
		contents = xyzw;
	}
	
	public double[] getContents () {
		return contents;
	}
	
	public double getMagnitude () {
		double x = contents[0];
		double y = contents[1];
		double z = contents[2];
		double w = contents[3];
		return Math.sqrt(x*x + y*y + z*z + w*w);
	}
	
	public double getSquareMagnitude () {
		double x = contents[0];
		double y = contents[1];
		double z = contents[2];
		double w = contents[3];
		return x*x + y*y + z*z + w*w;
	}
	
	public static Vector normaize (Vector v) {
		return mult(v, 1.0 / v.getMagnitude());
	}
	
	public static Vector integerize (Vector v) {
		double[] c = v.getContents();
		return new Vector (Math.round(c[0]), Math.round(c[1]), Math.round(c[2]), Math.round(c[3]));
	}
	
	public static Vector add (Vector a, Vector b) {
		double[] aC = a.getContents();
		double[] bC = b.getContents();
		return new Vector (aC[0] + bC[0], aC[1] + bC[1], aC[2] + bC[2], aC[3] + bC[3]);
	}
	
	public static double dot (Vector a, Vector b) {
		double total = 0;
		total += (a.getContents()[0] * b.getContents()[0]);
		total += (a.getContents()[1] * b.getContents()[1]);
		total += (a.getContents()[2] * b.getContents()[2]);
		total += (a.getContents()[3] * b.getContents()[3]);
		return total;
	}
	
	public static Vector cross (Vector aVec, Vector bVec) {
		double[] a = aVec.getContents();
		double[] b = bVec.getContents();
		return new Vector (a[2] * b[3] - a[3] * b[2],
				a[3] * b[1] - a[1] * b[3],
				a[1] * b[2] - a[2] * b[1],
				1);
	}
	
	public static Vector mult (Vector a, double b) {
		double[] aCont = a.getContents();
		return new Vector (aCont[0] * b, aCont[1] * b, aCont[2] * b, aCont[3] * b);
	}
}
