interface Box {
	void pack();
	void seal();
}

class GiftBox implements Box {
	public void pack() {
		System.out.println("pack box");
	}
	public void seal() {
		System.out.println("pack box");
	}
}

// Przyklad slabego projektu - redundancja kodu
class MailerBox1 implements Box {
	public void pack() {
		System.out.println("pack box");
	}
	public void seal() {
		System.out.println("pack box");
	}
	public void addPostage() {
		System.out.println("affix stamps");
	}
	public void ship() {
		System.out.println("put in mailbox");
	}
}

interface Mailer {
	void addPostage();
	void ship();
}

// Przyklad dobrego projektu - uzycie kompozycji i delegacji
class MailerBox2 implements Box, Mailer {
	private Box box;
	
	public MailerBox2(Box box) {
		this.box = box;
	}
	public void pack() {
		box.pack();
	}
	public void seal() {
		box.seal();
	}
	public void addPostage() {
		System.out.println("affix stamps");
	}
	public void ship() {
		System.out.println("put in mailbox");
	}
}