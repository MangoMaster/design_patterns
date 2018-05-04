import java.util.ArrayList;

public class Weather implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public Weather() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); ++i) {
            Observer tempObserver = observers.get(i);
            // ArrayList的用法？
            tempObserver.update(temperature, humidity, pressure);
            // 将temperature humidity pressure打包为Data的子类WeatherData更好？
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}