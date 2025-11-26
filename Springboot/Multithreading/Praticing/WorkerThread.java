public class WorkerThread extends Thread {
    private final String threadName;

    public WorkerThread(String threadName) {
        this.threadName = threadName;
    }
    public void run() {
        System.out.println("Worker " + threadName + " started.");
        for (int i = 1; i <=5 ; i++) {
            System.out.println(threadName + " is working on task " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker " + threadName + " finished.");
    }

    public static void main(String[] args) {
        Thread w1 = new WorkerThread("A");
        Thread w2 = new WorkerThread("B");
        Thread w3 = new WorkerThread("C");

        w1.start();
        w2.start();
        w3.start();
    }
}
