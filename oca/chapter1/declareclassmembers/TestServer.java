class TestServer {
	int count = 9;
	
	public void logIn() {
		int count = 10;
		System.out.println("the local count is " + count); 
	}
	
	public void doSomething(int i) {
		// count = i; // ILLEGAL
	}
	
	public void count() {
		System.out.println("the instance count is " + count);
	}
	
	public static void main(String[] args) {
		new TestServer().logIn();
		new TestServer().count();
	}
}
