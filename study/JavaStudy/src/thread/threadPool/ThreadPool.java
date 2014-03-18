package thread.threadPool;

import java.util.LinkedList;

public class ThreadPool extends ThreadGroup {
    private boolean isClosed = false; // thread is close or not

    private static int threadpoolID; // threadPool id

    private LinkedList<Runnable> workQueue; //

    private int threadID; // threadId

    /**
     * @param poolsize
     */
    public ThreadPool(int poolsize) {
        super("threadpool-" + (threadpoolID++));
        //
        setDaemon(true);

        workQueue = new LinkedList<Runnable>();
        for (int i = 0; i < poolsize; i++) {
            // create workThread
        }
    }

    public synchronized void execute(Runnable task) {
        if (isClosed) {
            throw new IllegalStateException();
        }
        if (task != null) {
            workQueue.add(task);
            notify(); // wake up the workThread
        }
    }

    protected synchronized Runnable getTask() throws InterruptedException {
        while (workQueue.size() == 0) {
            if (isClosed) {
                return null;
            }
            wait(); // if this not not task in queue, wait the task
        }
        return workQueue.removeFirst();
    }

    public synchronized void close() {
        if (!isClosed) {
            isClosed = true;
            workQueue.clear();
            interrupt(); // interrupt all threads
        }
    }

    public void join() {
        synchronized (this) {
            isClosed = true;
            notifyAll();
        }
        // activeCount() TODO
        Thread[] threads = new Thread[activeCount()];

        int count = enumerate(threads); // number of alive work threads
        for (int i = 0; i < count; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {

            }
        }
    }

    private class WorkThread extends Thread {
        public WorkThread() {
            // add workThread to threadPool
            super(ThreadPool.this, "WorkThread-" + (threadID++));
        }

        public void run() {
            // judge the thread is interrupt or not
            while (!isInterrupted()) {
                Runnable task = null;
                try {
                    task = getTask();
                } catch (InterruptedException e) {
                }

                if (task == null) {
                    return;
                }

                try {
                    task.run();
                } catch (Throwable e) {

                }
            }
        }
    }
}
