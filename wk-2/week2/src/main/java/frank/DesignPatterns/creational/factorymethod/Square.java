package frank.DesignPatterns.creational.factorymethod;

import java.awt.*;


public class Square implements Shape {
    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.gray); // Set the color to blue
        g.fillRect(x, y, 100, 100); // it will be drawing a square with top-left corner (x, y)
    }
}