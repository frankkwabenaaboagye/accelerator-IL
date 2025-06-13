import java.util.ArrayList;
import java.util.List;

public class LeakCrashDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> leakList = new ArrayList<>();
        int round = 0;

        while (true) {
            for (char c = 'A'; c <= 'Z'; c++) {
                String str = c + String.valueOf(round).repeat(1000);
                leakList.add(str);
            }

            System.out.println("Round: " + round + " | Size: " + leakList.size());
            round++;
            Thread.sleep(200);  // Leak slowly
        }
    }
}