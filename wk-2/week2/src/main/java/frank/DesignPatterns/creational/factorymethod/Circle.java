package frank.DesignPatterns.creational.factorymethod;

import java.awt.*;

public class Circle implements Shape {
    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLUE); // Set the color to blue
        g.fillOval(x, y, 100, 100); // will be drawing a circle with center (x, y) and radius 50
    }
}