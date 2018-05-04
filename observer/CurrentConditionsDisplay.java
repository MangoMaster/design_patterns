public class CurrentConditionsDisplay implements Observer, Display {

    private float temperature;
    private float humidity;
    private Subject weather;
    // 用Subject而不是Weather;可以runtime set

    public CurrentConditionsDisplay(Subject weather) {
        this.weather = weather;
        weather.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        // 不存数据，只存引用？
        // 将数据encapsulate更方便
        display();
        // update中display是否合适？
    }

    public void display() {
        System.out.println("Current conditions: " + temperature 
            + "F degrees and " + humidity + "% humidity");
    }
    // 不implements Display, 而是composite Display —— Strategy Pattern
}