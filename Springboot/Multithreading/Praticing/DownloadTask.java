// Khởi tạo lớp Thread bằng cách triển khai giao diện Runnable
// và sử dụng đối tượng Thread khác để chạy nó (File này không phải 1 Thread trực tiếp)
// Đây chỉ mô tả logic của công việc cần thực hiện trong một Thread
// => Tách biệt nhiệm vụ tốt hơn (Concern Separation)

public class DownloadTask implements Runnable {
    // Vẫn có thể kế thừa (extends) một class khác nếu cần
    // Đồng thời có thể triển khai (implements) nhiều giao diện khác

    // => Linh hoạt hơn vì cho phép đa kế thừa thông qua giao diện khác (interface)
    private final String fileName;
    private final int downloadTimeInSeconds;

    public DownloadTask(String fileName, int downloadTimeInSeconds) {
        this.fileName = fileName;
        this.downloadTimeInSeconds = downloadTimeInSeconds;
    }

    @Override
    public void run() {
        System.out.println("Starting download: " + fileName);
        try {
            Thread.sleep(downloadTimeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished download: " + fileName);
    }

    public static void main(String[] args) {
        Thread file1 = new Thread(new DownloadTask("file1", 2));
        Thread file2 = new Thread(new DownloadTask("file2", 4));
        Thread file3 = new Thread(new DownloadTask("file3", 3));

        file1.start();
        file2.start();
        file3.start();
        // Logic nằm trong Runnable -> có thể:
        // Chạy bằng nhiều Thread khác nhau nếu cần
        // Đưa vào ExecutorService để quản lý Thread pool dễ dàng hơn
        // -> Reusability cao hơn
        // Có thể tái sử dụng đối tượng Runnable vào nhiều Thread khác nhau và dễ dàng quản lí Thread pool
    }
}
