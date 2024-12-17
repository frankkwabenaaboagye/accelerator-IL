package frank.DesignPatterns.creational.abstractfactory.concretefactory;

import frank.DesignPatterns.creational.abstractfactory.abstractfactoryinterface.UIFactory;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Checkbox;
import frank.DesignPatterns.creational.abstractfactory.concreteproducts.WindowsButton;
import frank.DesignPatterns.creational.abstractfactory.concreteproducts.WindowsCheckbox;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Button;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}