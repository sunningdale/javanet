package thread.multiThread;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gate gate = new Gate();
		new UserThread(gate,"Alice","Alaska").start();
		new UserThread(gate,"Bobby","Brazil").start();
		new UserThread(gate,"Chris","Canada").start();

	}

}
