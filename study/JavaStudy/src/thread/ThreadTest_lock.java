package thread;

public class ThreadTest_lock  extends Thread {
	
	public static void main (String[] agrs){
		ThreadTest_lock test1 = new ThreadTest_lock();
		// thread execute later
        Thread threadlock1 = new Thread(test1);
        threadlock1.start();
        // main method first execute
        test1.testrun();
        System.out.println("threadlock1.getid:"+threadlock1.getId());
        System.out.println("threadlock1.getname:"+threadlock1.getName());
        System.out.println("threadlock1.priority:"+threadlock1.getPriority());
        System.out.println("test1.getid:"+test1.getId());
        System.out.println("test1.getname:"+test1.getName());
        System.out.println("test1.priority:"+test1.getPriority());
        System.out.println(Thread.activeCount());
		
	}

	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("start--------------");
	}
	
	public synchronized void testrun(){
		System.out.println("testrun--start--------------");
	}
	
}