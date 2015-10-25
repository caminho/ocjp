class Account {
	private int balance = 50;
		
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}

public class AccountDanger implements Runnable {
	
	private Account account = new Account();
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			withdraw(10);
			//Thread.yield();
			if (account.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}
	
	private synchronized void withdraw(int x) {
		if (account.getBalance() < x) {
			System.out.println("Not enough in account to withdraw " 
				+ account.getBalance());
		} else {			
			System.out.println(Thread.currentThread().getName()
				+ " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			account.withdraw(x);
			System.out.println(Thread.currentThread().getName()
				+ " completes the withdraw withdraw");
		}
	}
	
	public static void main(String[] args) {
		AccountDanger ad = new AccountDanger();
		
		Thread fred = new Thread(ad, "Fred");
		Thread lucy = new Thread(ad, "Lucy");
		
		fred.start();
		lucy.start();
	}
}