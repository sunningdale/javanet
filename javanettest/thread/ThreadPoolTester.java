package thread;

public class ThreadPoolTester {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int numTasks = 0;
        int poolSize = 0;
        ThreadPool threadPool = new ThreadPool(poolSize);

        for (int i = 0; i < numTasks; i++) {
            threadPool.execute(createTask(i));
        }
        // wait for workThreads complete all task
        threadPool.join();
    }

    private static Runnable createTask(final int taskID) {
        return new Runnable() {
            public void run() {
                System.out.println("createTask-" + taskID + "-start");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("createTask-" + taskID + "-end");
            }
        };

    }

}
