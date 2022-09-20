package Array;

public class _1701_AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double totalWaitTime = 0;
        double endAt = 0;

        for (int[] customer : customers) {
            endAt = Math.max(endAt, customer[0]) + customer[1];
            totalWaitTime += endAt - customer[0];
        }

        return totalWaitTime / n;
    }
}
