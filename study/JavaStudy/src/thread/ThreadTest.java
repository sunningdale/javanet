package thread;

public class ThreadTest {

    /**
     * main‚ğÀs‚·‚éB<br>
     * @param args
     */
    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        //test.testThread2();
        test.testThread2();
    }
    
    private void testThread1(){
     Thread thread = new Thread(){
         public void run(){
             for (int i = 0; i < 1000; i++){
              System.out.println(Thread.currentThread().getName() + i);   
             }
         }
     };
        thread.start();
    }
    
    private void testThread2(){  
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    System.out.println(Thread.currentThread().getName() + i);   
                   }
                
            }
        });
        thread.start();
    }
}
