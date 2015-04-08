interface Bounceable extends Moveable, Spherical {
	void bounce();
	void setBounceFactor(int bf);
}

interface Moveable {
	void moveIt();
}

interface Spherical {
	void doSphericalThing();
}

class Ball implements Bounceable {
	@Override
	public void bounce() {
		System.out.println("Bouncing a ball");
	}
	
	@Override
	public void setBounceFactor(int bf) {
		System.out.println("Setting bounce factor for a ball: " + bf);
	}
	
	@Override
	public void moveIt() {}
	
	@Override
	public void doSphericalThing() {}
}
