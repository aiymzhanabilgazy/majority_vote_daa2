package benchmarks;

import algorithms.MajorityVote;
import metrics.MajorityMetrics;
import metrics.MajorityCsvExporter;

import java.util.Random;

public class MajorityBenchmark {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 2000, 5000, 10000};
        MajorityCsvExporter exporter = new MajorityCsvExporter("majority_metrics.csv");
        exporter.writeHeader();

        for (int n : sizes) {
            int[] arr = generateArray(n);
            MajorityMetrics metrics = new MajorityMetrics();
            MajorityVote algo = new MajorityVote();

            algo.majorityElement(arr, metrics);
            exporter.appendRecord(n, metrics);

            System.out.println("Done for n = " + n);
        }
    }

    private static int[] generateArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        int majorityValue = random.nextInt(5);

        for (int i = 0; i < n / 2 + 1; i++) {
            arr[i] = majorityValue;
        }
        for (int i = n / 2 + 1; i < n; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
}

