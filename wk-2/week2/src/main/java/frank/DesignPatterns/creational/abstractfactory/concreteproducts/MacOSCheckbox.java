package frank.DesignPatterns.creational.abstractfactory.concreteproducts;

import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS Checkbox");
    }
}