package application;

/*
 * Project Name: Car Library Project 
 * Class Name: Car.java
 * Author Name: Bryant Le
 * Date (Last Updated): 05/01/2024
 * Description: This class declares variables as private, 
 * and utilizes get and set methods to update the variables. 
 * This allows for better control of the class attributes and methods. 
 * "Main.java" tests the functionality of this class.
 */
public class Car {

    // Initialized variables for car object
    private int CarID;
    private String model;
    private String make;
    private int year;
    private String color;
    private int wheels;
    private int vin;
    private boolean available;
    private OwnerInfo ownerInfo;

    // Constructors for car object
    public Car(int CarID, String model, String make, int year, String color, int wheels, int vin, boolean available) {
        this.CarID = CarID;
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.vin = vin;
        this.available = available;
    }

    // Getter for car availability
    public boolean getAvailable() {
        return available;
    }

    // Getter for Car ID
    public int getCarID() {
        return CarID;
    }

    // Getter for car color
    public String getColor() {
        return color;
    }

    // Getter for car make
    public String getMake() {
        return make;
    }

    // Getter for car model
    public String getModel() {
        return model;
    }

    // Getter for OwnerInfo
    public OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }

    // Getter for car vin
    public int getVin() {
        return vin;
    }

    // Getter for car wheels
    public int getWheels() {
        return wheels;
    }

    // Getter for car year
    public int getYear() {
        return year;
    }

    // Setter for car availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

        // Getter for OwnerInfo
    public OwnerInfo getOwnerInfo() {
    	return ownerInfo;
    }

    // Setter for Car ID
    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    // Setter for car color
    public void setColor(String color) {
        this.color = color;
    }

    // Setter for car make
    public void setMake(String make) {
        this.make = make;
    }

    // Setter for car model
    public void setModel(String model) {
        this.model = model;
    }

    // Setter for Owner Info
    public void setOwnerInfo(OwnerInfo ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    // Setter for car vin
    public void setVin(int vin) {
        this.vin = vin;
    }

    // Setter for car wheels
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    // Setter for car year
    public void setYear(int year) {
        this.year = year;
    }
}
