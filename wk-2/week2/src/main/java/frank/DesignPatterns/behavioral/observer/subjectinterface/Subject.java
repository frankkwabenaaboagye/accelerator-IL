package frank.DesignPatterns.behavioral.observer.subjectinterface;

import frank.DesignPatterns.behavioral.observer.observerinterface.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}