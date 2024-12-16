package frank.creational.abstractfactory.concreteproducts;

import frank.creational.abstractfactory.productinterfaces.Button;

public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS Button");
    }
}