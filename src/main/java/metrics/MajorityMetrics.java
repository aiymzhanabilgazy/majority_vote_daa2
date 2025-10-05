package metrics;

public class MajorityMetrics {
    private long comparisons = 0;
    private long arrayAccesses = 0;
    private long memoryAllocations = 0;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    public void incrementMemoryAllocations() {
        memoryAllocations++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public long getMemoryAllocations() {
        return memoryAllocations;
    }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }
}
