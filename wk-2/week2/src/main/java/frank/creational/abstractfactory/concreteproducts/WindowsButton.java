package frank.creational.abstractfactory.concreteproducts;

import frank.creational.abstractfactory.productinterfaces.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Button");
    }
}