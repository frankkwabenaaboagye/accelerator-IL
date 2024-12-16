package frank.creational.abstractfactory.concretefactory;

import frank.creational.abstractfactory.abstractfactoryinterface.UIFactory;
import frank.creational.abstractfactory.concreteproducts.WindowsButton;
import frank.creational.abstractfactory.concreteproducts.WindowsCheckbox;
import frank.creational.abstractfactory.productinterfaces.Button;
import frank.creational.abstractfactory.productinterfaces.Checkbox;

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