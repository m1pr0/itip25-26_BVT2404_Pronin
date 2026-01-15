public class MaxInMatrixSimple {
    private static final int[][] MATRIX = {
            {1, 2, 3},
            {7, 8, 9},
            {4, 5, 6}
    };

    private static volatile int[] maxInRow;

    public static void main(String[] args) throws InterruptedException {
        int rows = MATRIX.length;
        maxInRow = new int[rows];

        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                int max = MATRIX[rowIndex][0];
                for (int num : MATRIX[rowIndex]) {
                    if (num > max) max = num;
                }

                synchronized(MaxInMatrixSimple.class) {
                    maxInRow[rowIndex] = max;
                }

            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int globalMax = maxInRow[0];
        for (int i = 1; i < rows; i++) {
            if (maxInRow[i] > globalMax) {
                globalMax = maxInRow[i];
            }
        }

        System.out.println(globalMax);
    }
}
