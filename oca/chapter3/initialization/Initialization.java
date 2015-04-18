class Parent {
	Parent() {
		System.out.println("Najpierw rodzic!");
	}
}

public class Initialization extends Parent {
	int x = go(1);
	
	{
		x = go(2);
	}
	
	Initialization() {
		x = go(3);
	}
	
	public static void main(String[] args) {
		Initialization init = new Initialization();
	}
	
	static int go(int ret) {
		System.out.println(ret);
		return ret;
	}
}
