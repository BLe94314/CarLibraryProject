public class CarInventory {
    // Initialized car and num (counter) variables
    private Car[] cars;
    private int num = 0;

    // Constructor for car inventory
    public CarInventory(int numOfCars) {
        this.cars = new Car[numOfCars];
        this.num = 0;
    }

    // Adds the cars to inventory
    public void addCar(Car car) {
        if (num < cars.length) {
            cars[num++] = car;
        }
    }

    // Outputs the car's attributes to console
    public void output() {
        for (int i = 0; i < num; i++) {
            System.out.println("Name: " + cars[i].getName() + "\nMake: " + cars[i].getMake() + "\nYear: "
                    + cars[i].getYear() + "\nColor: " + cars[i].getColor() + "\nNumber of Wheels: "
                    + cars[i].getWheels() + "\nVIN: " + cars[i].getVin() + "\n");
        }
    }
}
