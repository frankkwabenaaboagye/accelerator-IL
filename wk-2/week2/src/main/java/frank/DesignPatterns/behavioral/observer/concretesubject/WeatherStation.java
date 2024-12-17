package frank.DesignPatterns.behavioral.observer.concretesubject;

import frank.DesignPatterns.behavioral.observer.observerinterface.Observer;
import frank.DesignPatterns.behavioral.observer.subjectinterface.Subject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
