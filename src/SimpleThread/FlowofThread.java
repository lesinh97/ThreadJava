package SimpleThread;

public class FlowofThread {
	public static void main(String[] args) {
		RunthisThread t1 = new RunthisThread("Thor", 200);
		RunthisThread t2 = new RunthisThread("Logan", 20);
		RunthisThread t3 = new RunthisThread("Aloalo", 50);
		t1.run();
		t2.run();
		t3.run();
	}

}
class RunthisThread extends Thread {
	private int delay;
	public RunthisThread(String label, int d) {
		// TODO Auto-generated constructor stub
		super("Thread: " + label );
		delay = d;
	}
	@Override
	public void run() {
		super.run();
		// TODO Auto-generated method stub
		for (int count = 1, row = 1; row < 20; row++, count++ ) {
			try {
				System.out.format("Line #%d from %s\n", count, getName()); 
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException e) {
				// TODO: handle exception
				// bleubleu
			}
		}
	}
}
