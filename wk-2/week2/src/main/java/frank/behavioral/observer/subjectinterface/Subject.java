package frank.behavioral.observer.subjectinterface;

import frank.behavioral.observer.observerinterface.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}