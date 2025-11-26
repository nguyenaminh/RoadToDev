
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Sử dụng ExecutorService để quản lý Thread pool
// Thay vì tự tạo và quản lý từng Thread một cách thủ công
// Giúp tái sử dụng Thread, tối ưu hiệu năng và quản lý dễ dàng hơn
public class TaskA implements Runnable {

    private final int id;

    public TaskA(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " is running");
        try {
            int time = 500 + new Random().nextInt(500);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " is finished");
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            pool.submit(new TaskA(i));
        }

        pool.shutdown();
    }
}
