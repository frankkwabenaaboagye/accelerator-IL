import java.util.ArrayList;
import java.util.List;

public class NoLeakMonitor {
    public static void main(String[] args) throws InterruptedException {
        List<String> stableList = new ArrayList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            stableList.add("Letter: " + c);
        }

        System.out.println("Initial list created. Attach VisualVM and observe.");
        while (true) {
            Thread.sleep(1000); // Keep running, but doing nothing
        }
    }
}