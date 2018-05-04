import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, Display {

    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable o) {
        observable = o;
        o.addObserver(this);
    }

    public void update(Observable obs, Object arg) {
        if (obs instanceof Weather) {
            Weather weather = (Weather) obs;
            this.temperature = weather.getTemperature();
            this.humidity = weather.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions: " + temperature
            + "F degress and " + humidity + "% humidity");
    }
}