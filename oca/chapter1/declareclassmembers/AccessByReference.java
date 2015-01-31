class Zoo {
	public String coolMethod() {
		return "Wow baby!";
	}
}

class Moo {
	public void uzeAZoo() {
		Zoo z = new Zoo();
		System.out.println("A zoo says, " + z.coolMethod());
	}
}
