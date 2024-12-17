package frank.DesignPatterns.creational.abstractfactory.concretefactory;

import frank.DesignPatterns.creational.abstractfactory.abstractfactoryinterface.UIFactory;
import frank.DesignPatterns.creational.abstractfactory.concreteproducts.MacOSButton;
import frank.DesignPatterns.creational.abstractfactory.concreteproducts.MacOSCheckbox;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Button;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Checkbox;

public class MacOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}