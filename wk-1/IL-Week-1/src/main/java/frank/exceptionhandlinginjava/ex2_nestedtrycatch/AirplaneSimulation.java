package frank.exceptionhandlinginjava.ex2_nestedtrycatch;

public class AirplaneSimulation {
    public static void main(String[] args) {
        try {

            System.out.println("Initializing main control system...");

            try {

                System.out.println("Activating navigation system...");

                try {
                    System.out.println("Fetching sensor data...");
                    throw new ArithmeticException("Sensor division error detected!");
                } catch (ArithmeticException e) {
                    System.out.println("Critical Error: " + e.getMessage());
                    System.out.println("Fallback to redundant sensor data...");
                }

                System.out.println("Navigation system operational.");

                throw new IllegalArgumentException("Invalid navigation input detected!"); // I am simulating another exception in the navigation

            } catch (IllegalArgumentException e){
                System.out.println("Navigation Error: " + e.getMessage());
                System.out.println("Switching to manual navigation mode...");
            }

            System.out.println("Main control system operational.");

            throw new NullPointerException("Communication link lost!"); // I am simulating with this

        } catch (NullPointerException e){
            System.out.println("System Failure: " + e.getMessage());
            System.out.println("Activating emergency protocols...");
        }

        System.out.println("Airplane simulation complete.");
    }
}
