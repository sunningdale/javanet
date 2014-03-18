package thread;

public class ThreadTest_synchronized {

    class Inner {
        private void m4t1() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":Inner.m4t1=" + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void m4t2() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":Inner.m4t2=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    private void m4t1(Inner inner){
        synchronized(inner){
            inner.m4t1();
        }
    }
    
    private void m4t2(Inner inner){
        synchronized(inner){
            inner.m4t2();
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        final ThreadTest_synchronized thread = new ThreadTest_synchronized();
        final Inner inner = thread.new Inner();
        
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                thread.m4t1(inner);
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                thread.m4t2(inner);
            }
            
        },"t2");
        thread1.start();
        thread2.start();

    }

}
