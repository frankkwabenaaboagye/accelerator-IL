import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalLeakCrash {
    private static final String[] animals = {
        "Dog", "Cat", "Lion", "Tiger", "Elephant", "Zebra", "Giraffe", "Bear", "Wolf", "Fox"
    };

    public static void main(String[] args) throws InterruptedException {
        List<String> animalList = new ArrayList<>();
        Random rand = new Random();
        int round = 0;

        while (true) {
            for (String animal : animals) {
                String s = animal + rand.nextInt(1000) + "_" + round;
                animalList.add(s.repeat(100)); // Heavy memory load
            }

            System.out.println("Round: " + round + " | List size: " + animalList.size());
            round++;
            Thread.sleep(200);
        }
    }
}