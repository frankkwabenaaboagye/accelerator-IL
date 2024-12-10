package frank.oop_deep_dive.labtwo;

public class TestInnerClass {
    public static void main(String[] args) {
        Rocket rocket = new Rocket("Falcon 9", 549054);
        rocket.displayRocketDetails();

        Rocket.Engine engine = rocket.new Engine("Merlin", 7607000);
        engine.displayEngineDetails();

    }
}
