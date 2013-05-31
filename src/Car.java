public class Car {
    private Engine engine;
    private Wheels wheels;
 
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
 
    public boolean hasWheels() {
        return wheels != null;
    }
 
    public boolean hasEngine() {
        return engine != null;
    }
}

