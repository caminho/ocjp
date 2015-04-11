
class Parent {
	Parent() {
		System.out.println("Parent1");
	}
}

class Init extends Parent {
	
	Init(int x) {
		System.out.println("init with arg");
	}
	
	static {
		System.out.println("init static 1");
	}
	
	{
		System.out.println("init block 1");
	}
	
	Init() {
		this(5);
		System.out.println("init no arg");
	}
	
	static {
		System.out.println("init static 2");
	}
	
	
	{
		System.out.println("init block 2");
	}
}

public class InitBlocks {
	public static void main(String[] args) {
		new Init(5);
		new Init();
	}
}
