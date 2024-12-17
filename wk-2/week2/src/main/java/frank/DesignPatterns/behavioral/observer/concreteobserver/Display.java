package frank.DesignPatterns.behavioral.observer.concreteobserver;

import frank.DesignPatterns.behavioral.observer.observerinterface.Observer;

public class Display implements Observer {
    private String displayName;

    public Display(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void update(float temperature) {
        System.out.println(displayName + " updated: Current temperature is " + temperature + "°C");
    }
}

