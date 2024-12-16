package frank.creational.abstractfactory.abstractfactoryinterface;

import frank.creational.abstractfactory.productinterfaces.Button;
import frank.creational.abstractfactory.productinterfaces.Checkbox;

public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}