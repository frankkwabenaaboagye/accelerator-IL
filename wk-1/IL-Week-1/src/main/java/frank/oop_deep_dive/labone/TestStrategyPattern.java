package frank.oop_deep_dive.labone;

public class TestStrategyPattern {

    public static void main(String[] args) {
        TextFormatter formatter = new CapTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        editor.publishText("Software Engineering is great");


        formatter = new LowerTextFormatter();
        editor = new TextEditor(formatter);
        editor.publishText("JAVA IS splendid");

    }
}
