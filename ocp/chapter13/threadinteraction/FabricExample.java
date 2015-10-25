class MachineSteps {
	private int fabricRoll;
	private int cuttingSpeed;
	
	public MachineSteps(int fabricRoll, int cuttingSpeed) {
		this.fabricRoll = fabricRoll;
		this.cuttingSpeed = cuttingSpeed;
		//...
	}
	
	public String toString() {
		return "[fabricRoll: " + fabricRoll 
			+ ", cuttingSpeed: " + cuttingSpeed 
			+ "]";
	}
}

class Operator extends Thread {
	
	private MachineSteps steps;
	
	public MachineSteps getMachineSteps() {
		return steps;
	}
	
	public void run() {
		try {
			while (true) {
				System.out.println("OPERATOR: Getting shape from user");
				Thread.sleep(200);
				synchronized (this) {
					System.out.println("OPERATOR: Calculating new steps");
					Thread.sleep(200);
					
					steps = new MachineSteps(
						(int) (Math.random()*10.0),
						(int) (Math.random()*10.0)
					);				
					notify();				
					System.out.println("OPERATOR: Steps are: " + steps);
				}
			}
		} catch (InterruptedException e) {}
	}
}

class Machine extends Thread {
	private Operator operator;
	
	public Machine(Operator operator) {
		this.operator = operator;
	}
	
	public void run() {
		try {
			while (true) {
				synchronized (operator) {
					System.out.println("MACHINE: waiting for steps...");
					try {
						operator.wait();
					} catch (InterruptedException e) {}				
					System.out.println("MACHINE: steps being sent to hardware are: " 
						+ operator.getMachineSteps());
					for (int i = 0; i < 10; i++) {
						System.out.println("MACHINE: Sending " + (i+1) 
							+ " step to hardware");
						Thread.sleep(20);
					}
					System.out.println("MACHINE: all steps sent succesfully");
				}
			}
		} catch (InterruptedException e) {}
	}
}

public class FabricExample {
	
	public static void main(String[] args) {
		Operator operator = new Operator();
		Machine machine = new Machine(operator);
		machine.start();
		operator.start();
	}
}
