public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Cruze", "Chevrolet", 2013, "Blue", 4, 10001);
        Car car2 = new Car("Silverado", "Chevrolet", 2024, "Gray", 4, 10002);

        CarInventory inventory = new CarInventory(2);

        inventory.addCar(car1);
        inventory.addCar(car2);

        System.out.println("---List of Cars---");
        inventory.output();
    }
}
