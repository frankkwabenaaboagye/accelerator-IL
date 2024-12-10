package frank.oop_deep_dive.labone;

public class LowerTextFormatter implements TextFormatter{
    @Override
    public void format(String text) {
        System.out.println("[LowerTextFormatter]: " +  text.toLowerCase());
    }
}
