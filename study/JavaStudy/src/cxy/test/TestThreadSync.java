package cxy.test;

public class TestThreadSync {
	// two thread cannot access method at same time
	// x.iSyncA() and x.iSyncA()
	// x.iSyncA() and x.iSyncB()
	// x.iSyncB() and x.iSyncB()
	
	// TestMethod.cSyncA() and TestMethod.cSyncA()
	// TestMethod.cSyncB() and TestMethod.cSyncB()
	// TestMethod.cSyncA() and TestMethod.cSyncB()
	
	// x.cSyncA() and x.cSyncA()
	// x.cSyncA() and x.cSyncB()
	// x.cSyncB() and x.cSyncB()
	// x.cSyncA() and y.cSyncA()
	// x.cSyncA() and y.cSyncB()
	// x.cSyncB() and y.cSyncB()

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final TestsyncMethod x = new TestsyncMethod();
		final TestsyncMethod y = new TestsyncMethod();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("11111");
				 x.iSyncA(); 
				//2// x.iSyncA(); 
				
				
				//2// x.iSyncA();
				//2// x.iSyncA();
				//3// TestMethod.cSyncA();
				//5// x.cSyncB();
			}

		}).start();
		new Thread(new Thread() {
			@Override
			public void run() {
				System.out.println("22222");
				 y.iSyncA();
				//2// TestMethod.cSyncA();
				
				
				//2// x.iSyncA();
				//2// x.iSyncB();
				//3// TestMethod.cSyncB();
				//5// y.cSyncB();
			}
		}).start();

	}

}
