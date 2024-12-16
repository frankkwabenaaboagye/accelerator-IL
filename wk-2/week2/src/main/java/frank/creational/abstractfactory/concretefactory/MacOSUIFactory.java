package frank.creational.abstractfactory.concretefactory;

import frank.creational.abstractfactory.abstractfactoryinterface.UIFactory;
import frank.creational.abstractfactory.concreteproducts.MacOSButton;
import frank.creational.abstractfactory.concreteproducts.MacOSCheckbox;
import frank.creational.abstractfactory.productinterfaces.Button;
import frank.creational.abstractfactory.productinterfaces.Checkbox;

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