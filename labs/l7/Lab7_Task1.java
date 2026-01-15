import java.util.concurrent.atomic.AtomicInteger;

public class Lab7_Task1 {
    private static final int[] ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final AtomicInteger sumFirstHalf = new AtomicInteger(0);
    private static final AtomicInteger sumSecondHalf = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < ARRAY.length / 2; i++) {
                sumFirstHalf.addAndGet(ARRAY[i]);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = ARRAY.length / 2; i < ARRAY.length; i++) {
                sumSecondHalf.addAndGet(ARRAY[i]);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int totalSum = sumFirstHalf.get() + sumSecondHalf.get();
        System.out.println(totalSum);
    }
}