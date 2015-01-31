class Zoo {
	public String coolMethod() {
		return "Wow baby!";
	}
}

class Moo extends Zoo {
	public void useMyCoolMethod() {
		System.out.println("Moo says, " + this.coolMethod());
		Zoo z = new Zoo();
		System.out.println("Zoo says, " + z.coolMethod());
	}
}
