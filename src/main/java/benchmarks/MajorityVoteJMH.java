package benchmarks;

import algorithms.MajorityVote;
import metrics.MajorityMetrics;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class MajorityVoteJMH {

    private int[] input;
    private MajorityVote algo;
    private MajorityMetrics metrics;

    @Param({"100", "1000", "2000","5000", "10000"})
    private int size;

    @Setup(Level.Trial)
    public void setup() {
        algo = new MajorityVote();
        metrics = new MajorityMetrics();
        input = generateArray(size);
    }

    private int[] generateArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        int majorityValue = random.nextInt(5);

        for (int i = 0; i < n / 2 + 1; i++) arr[i] = majorityValue;
        for (int i = n / 2 + 1; i < n; i++) arr[i] = random.nextInt(10);
        return arr;
    }

    @Benchmark
    public int testMajorityVote() {
        return algo.majorityElement(input, metrics);
    }
}

