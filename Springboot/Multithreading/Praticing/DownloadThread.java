// Khởi tạo Thread bằng cách kế thừa lớp Thread
// Bản thân là 1 Thread trực tiếp
// Vừa chứa logic công việc, vừa là Thread thực thi công việc đó
public class DownloadThread extends Thread {
    // Không thể kế thừa class nào khác do đã kế thừa Thread
    private final String fileName;
    private final int downloadTimeInSeconds;

    public DownloadThread(String fileName, int downloadTimeInSeconds) {
        this.fileName = fileName;
        this.downloadTimeInSeconds = downloadTimeInSeconds;
    }

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
        Thread file1 = new DownloadThread("file1",2);
        Thread file2 = new DownloadThread("file2",4);
        Thread file3 = new DownloadThread("file3",3);

        file1.start();
        file2.start();
        file3.start();
        // Một instance của Thread này không thể tái sử dụng để chạy lại
        // file1.start(); // Lỗi IllegalThreadStateException
        // Vì vậy, nếu muốn chạy lại, phải tạo instance mới
    }
}