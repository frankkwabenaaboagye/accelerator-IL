public class AutoGCDemo {
    public static void main(String[] args) throws InterruptedException {
        int round = 0;

        while (true) {
            for (char c = 'A'; c <= 'Z'; c++) {
                String s = new StringBuilder()
                        .append(c)
                        .append(String.valueOf(round).repeat(500))
                        .toString();
                // Not storing anywhere — eligible for GC
            }

            System.out.println("Created temporary objects in round: " + round);
            round++;
            Thread.sleep(200);
        }
    }
}
