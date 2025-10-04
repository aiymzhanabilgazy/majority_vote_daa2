package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class MajorityCsvExporter {

    private final String filePath;

    public MajorityCsvExporter(String filePath) {
        this.filePath = filePath;
    }

    public void writeHeader() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("n,comparisons,arrayAccesses,memoryAllocations\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendRecord(int n, MajorityMetrics metrics) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(n + "," +
                    metrics.getComparisons() + "," +
                    metrics.getArrayAccesses() + "," +
                    metrics.getMemoryAllocations() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
