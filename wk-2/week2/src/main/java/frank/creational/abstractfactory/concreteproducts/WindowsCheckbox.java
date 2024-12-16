package frank.creational.abstractfactory.concreteproducts;

import frank.creational.abstractfactory.productinterfaces.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Checkbox");
    }
}