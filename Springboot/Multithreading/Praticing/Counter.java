public class Counter{
    static class Counters {
        private int count = 0;
        
        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // Create Counter instance for 100 threads to increment
        Counters counter = new Counters();

        // Create a list to hold threads
        Thread[] threads = new Thread[100];

        // Initialize and start 100 threads, each incrementing the counter 1000 times
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread (() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
        }

        // Start all threads
        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
