package frank.behavioral.observer;

import frank.behavioral.observer.concreteobserver.Display;
import frank.behavioral.observer.concretesubject.WeatherStation;

public class Main {
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation(); // Subject

        Display display1 = new Display("Display 1"); // Observer
        Display display2 = new Display("Display 2"); // Observers

        // Register Displays as Observers
        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        // Change the temperature and notify observers
        System.out.println("Setting temperature to 25°C");
        weatherStation.setTemperature(25);  // Both displays will be notified

        System.out.println("\nSetting temperature to 30°C");
        weatherStation.setTemperature(30);  // Both displays will be notified

        // Unregister Display 1 and change temperature again
        weatherStation.removeObserver(display1);

        System.out.println("\nSetting temperature to 20°C");
        weatherStation.setTemperature(20);  // Only Display 2 will be notified
    }
}
