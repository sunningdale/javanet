package thread;

public class ThreadTest_join {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadA());
		Thread t2 = new Thread(new ThreadB());
		t1.start();
		//t1.join(); // wait t1 to be finished
		t2.start();


	}

}

 class ThreadA implements Runnable{

	@Override
	public void run() {
      int count = 0;
      while (count < 10){
    	  System.out.println("count="+count);
    	  count++;
      }	
	} 
 }
 

 class ThreadB implements Runnable{

	@Override
	public void run() {
	      int i = 0;
	      while (i < 10){
	    	  System.out.println("i="+i);
	    	  i++;
	      }	
	}
 }