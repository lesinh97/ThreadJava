package Daemon;

public class DaemonSimple {
	public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new WorkingThread(), "My Daemon Thread");
        dt.setDaemon(true);
        dt.start();
        System.out.println("Deamon running");
        // continue program
        Thread.sleep(3000);
        System.out.println("End daemon"
        		+ ">><< Finishing main program");
	}
}


