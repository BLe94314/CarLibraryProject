/*
 * Project Name: Car Library Project 
 * Class Name: CarInventory.java
 * Author Name: Bryant Le
 * Date (Last Updated): 04/08/2024
 * Description: This class declares an array of car objects and contains an iterative count for the number of total car objects. All car objects will be printed into the console and/or GUI class for the user. The user will proceed to rent one of the available cars. Functionality will be tested in the "Main.java" class.
 */
public class CarInventory {

    // Initialized car and num (counter) variables
    private Car[] cars;
    private OwnerInfo[] owners;
    private int num = 0;

    // Constructor for car inventory
    public CarInventory(int numOfCars) {
        this.cars = new Car[numOfCars];
        this.owners = new OwnerInfo[numOfCars];
        this.num = 0;
    }

    // Adds the cars to inventory along with owner information
    public void addCar(Car car, OwnerInfo ownerInfo) {
        if (num < cars.length && num < owners.length) {
            cars[num] = car;
            owners[num] = ownerInfo;
            num++;
        }
    }

    // Outputs the car's attributes along with owner information to console
    public void output() {
        for (int i = 0; i < num; i++) {
            System.out.println("--- Car ---");
            System.out.println("Name: " + cars[i].getName() + "\nMake: " + cars[i].getMake() + "\nYear: "
                    + cars[i].getYear() + "\nColor: " + cars[i].getColor() + "\nNumber of Wheels: "
                    + cars[i].getWheels() + "\nVIN: " + cars[i].getVin());
            System.out.println("--- Owner Information ---");
            System.out.println("First Name: " + owners[i].getFirstName() + "\nLast Name: " + owners[i].getLastName()
                    + "\nState: " + owners[i].getState() + "\nRegistration Date: " + owners[i].getRegistrationDate()
                    + "\nRemaining Balance: " + owners[i].getRemainingBalance() + "\nDealership Name: "
                    + owners[i].getDealershipName()
                    + "\nLicense Plate: " + owners[i].getLicensePlate() + "\n");
        }
    }
}
