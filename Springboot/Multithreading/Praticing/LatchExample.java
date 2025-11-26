

import java.util.concurrent.CountDownLatch;
import java.util.Random;

public class LatchExample implements Runnable {
    private final String taskName;
    private final CountDownLatch latch;
    
    public LatchExample(String taskName, CountDownLatch latch) {
        this.taskName = taskName;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskName + " started");
        try {
            int time = 1000 + new Random().nextInt(1000);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskName + " finished");
        latch.countDown();
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new LatchExample("A", latch));
        Thread t2 = new Thread(new LatchExample("B", latch));
        Thread t3 = new Thread(new LatchExample("C", latch));
        t1.start();
        t2.start();
        t3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main continues");
    }
}
