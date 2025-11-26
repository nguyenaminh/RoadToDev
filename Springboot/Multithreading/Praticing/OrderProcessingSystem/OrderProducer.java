package OrderProcessingSystem;

public class OrderProducer implements Runnable {
    private final int id;
    private final int amount;
    public OrderProducer(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= amount; i++) {
            System.out.println("Producer " + id + " produced order " + i);
            try {
                Thread.sleep(1000); // Simulate time taken to produce an order
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer " + id + " finished producing orders");
    }
    
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            Thread prod = new Thread(new OrderProducer(i, 5));
            prod.start();
        }
    }
}