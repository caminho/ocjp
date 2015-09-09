abstract class XXX {
	XXX() {
	
	}
}

class Util {
	static int getNumber(final String msg, final int n) {
		System.out.println(msg + " " + n);
		return n;
	}
}

class ParentClass {
	{
		x = Util.getNumber("ParentClass init block x ", 1);	
	}
	
	int x = Util.getNumber("ParentClass x", 2);
	
	
	ParentClass(int l) {
	
		z = Util.getNumber("ParentClass constructor z", l);	
	
	}
	
	int y = Util.getNumber("ParentClass y", 3);
	
	static int X = Util.getNumber("ParentClass static X", 4);
	static {
		X = Util.getNumber("ParentClass static block X ", 5);
	}
	
	{
		y = Util.getNumber("ParentClass init block y", 6);	
	}
	
	static {
		Y = Util.getNumber("ParentClass static block Y ", 7);
	}
	static int Y = Util.getNumber("ParentClass static Y", 8);

	int z = Util.getNumber("ParentClass z", 9);
	
	ParentClass() {
		this(Util.getNumber("ParentClass this argument", 1000));
	}
}

public class InitBlocksTest extends ParentClass {

	int k = 34;

	{
		x = Util.getNumber("InitBlocksTest init block x ", 1);	
	}
	
	int x = Util.getNumber("InitBlocksTest x", 2);
	
	InitBlocksTest() {
		this(Util.getNumber("InitBlocksTest constructor static method", 6554));	
	}
	
	InitBlocksTest(int h) {
//		super();
		z = Util.getNumber("InitBlocksTest constructor z", 3);	
	}
	
	int y = Util.getNumber("InitBlocksTest y", 4);
	
	
	static int X = Util.getNumber("InitBlocksTest static X", 5);
	static {
		X = Util.getNumber("InitBlocksTest static block X ", 6);
	}
	
	{
		y = Util.getNumber("InitBlocksTest init block y", 7);	
	}
	
	static {
		Y = Util.getNumber("InitBlocksTest static block Y ", 8);
	}
	static int Y = Util.getNumber("InitBlocksTest static Y", 9);



	int z = Util.getNumber("InitBlocksTest z", 10);


	public static void main(String[] args) {
		new InitBlocksTest();
	}
}

