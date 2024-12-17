package frank.DesignPatterns.creational.abstractfactory.abstractfactoryinterface;

import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Checkbox;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Button;

public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}