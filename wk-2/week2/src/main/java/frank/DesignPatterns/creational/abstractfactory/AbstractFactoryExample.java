package frank.DesignPatterns.creational.abstractfactory;

import frank.DesignPatterns.creational.abstractfactory.abstractfactoryinterface.UIFactory;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Checkbox;
import frank.DesignPatterns.creational.abstractfactory.concretefactory.MacOSUIFactory;
import frank.DesignPatterns.creational.abstractfactory.concretefactory.WindowsUIFactory;
import frank.DesignPatterns.creational.abstractfactory.productinterfaces.Button;

public class AbstractFactoryExample {
    private Button button;
    private Checkbox checkbox;

    public AbstractFactoryExample(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        UIFactory windowsFactory = new WindowsUIFactory();
        AbstractFactoryExample windowsUI = new AbstractFactoryExample(windowsFactory);
        windowsUI.renderUI();

        System.out.println();

        UIFactory macFactory = new MacOSUIFactory();
        AbstractFactoryExample macUI = new AbstractFactoryExample(macFactory);
        macUI.renderUI();
    }
}