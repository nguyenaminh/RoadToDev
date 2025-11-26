import java.util.Random;

public class JoinExample implements Runnable {
    private final String taskName;
    public JoinExample(String taskName) {
        this.taskName = taskName;
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
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new JoinExample("A"));
        Thread t2 = new Thread(new JoinExample("B"));
        Thread t3 = new Thread(new JoinExample("C"));
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main finished");
    }
}
