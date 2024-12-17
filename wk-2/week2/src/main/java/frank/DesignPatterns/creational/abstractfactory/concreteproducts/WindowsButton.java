package frank.DesignPatterns.creational.abstractfactory.concreteproducts;

import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Button");
    }
}