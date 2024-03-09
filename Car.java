public class Car {
    // Initialized variables
    private String name;
    private String make;
    private int year;
    private String color;
    private int wheels;
    private int vin;

    // Constructors
    public Car(String name, String make, int year, String color, int wheels, int vin) {
        this.name = name;
        this.make = make;
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.vin = vin;
    }

    // Getters and Setters
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
