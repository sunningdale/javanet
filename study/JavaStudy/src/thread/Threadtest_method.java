package thread;

public class Threadtest_method  implements Runnable{
    int number = 10;
    
    public void firstMethod() throws Exception {
        System.out.println("66666666666666");
        synchronized(this){
            number += 100;
            System.out.println(number);
        }
    }
    
    public void secondMethod() throws Exception{
        System.out.println("5555555555555555");
        synchronized(this){
            // explain form   http://www.cnblogs.com/DreamSea/archive/2012/01/16/SleepAndWaitDifferent.html
            //Thread.sleep(2000);
            this.wait(2000);
            number *= 200;
        }
    }


    public static void main(String[] args) throws Exception {
        Threadtest_method test = new Threadtest_method();
        System.out.println("-------1111111111111-----------");
        Thread thread = new Thread(test);
        System.out.println("-------2222222222222---------");
        thread.start();
        System.out.println("------33333333333333-----------");
        test.secondMethod();
        System.out.println("number="+test.number);
    }

    @Override
    public void run() {
        try {
            System.out.println("4444444444444444");
            firstMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
