public class Car {
    // Initialized variables for car object
    private String name;
    private String make;
    private int year;
    private String color;
    private int wheels;
    private int vin;

    // Constructors for car object
    public Car(String name, String make, int year, String color, int wheels, int vin) {
        this.name = name;
        this.make = make;
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.vin = vin;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getName() {
        return name;
    }

    public int getVin() {
        return vin;
    }

    public int getWheels() {
        return wheels;
    }

    public int getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
