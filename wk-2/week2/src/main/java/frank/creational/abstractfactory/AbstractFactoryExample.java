package frank.creational.abstractfactory;

import frank.creational.abstractfactory.abstractfactoryinterface.UIFactory;
import frank.creational.abstractfactory.concretefactory.MacOSUIFactory;
import frank.creational.abstractfactory.concretefactory.WindowsUIFactory;
import frank.creational.abstractfactory.productinterfaces.Button;
import frank.creational.abstractfactory.productinterfaces.Checkbox;

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