package cli1;
import algorithms.MajorityVote;
import metrics.MajorityMetrics;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("  java Main --n 1000");
            System.out.println("  java Main --benchmark");
            return;
        }

        if (args[0].equals("--n")) {
            int n = Integer.parseInt(args[1]);
            runSingle(n);
        } else if (args[0].equals("--benchmark")) {
            runBenchmark();
        } else {
            System.out.println("Unknown command. Try --n or --benchmark");
        }
    }

    private static void runSingle(int n) {
        int[] arr = generateArray(n);
        MajorityMetrics metrics = new MajorityMetrics();
        MajorityVote algo = new MajorityVote();

        int result = algo.majorityElement(arr, metrics);

        System.out.println("Input size: " + n);
        System.out.println("Majority element: " + result);
        System.out.println("Comparisons: " + metrics.getComparisons());
        System.out.println("Array accesses: " + metrics.getArrayAccesses());
    }

    private static void runBenchmark() {
        int[] sizes = {100, 1000, 2000, 5000, 10000};

        for (int n : sizes) {
            MajorityMetrics metrics = new MajorityMetrics();
            MajorityVote algo = new MajorityVote();

            int[] arr = generateArray(n);
            int result = algo.majorityElement(arr, metrics);

            System.out.printf(
                    "n=%d | result=%d | comparisons=%d | arrayAccesses=%d%n",
                    n, result, metrics.getComparisons(), metrics.getArrayAccesses()
            );
        }
    }

    private static int[] generateArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
}
