public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        // Car 1 owner information
        System.out.println("Enter owner's first name for Car 1:");
        String firstName1 = scanner.nextLine();

        System.out.println("Enter owner's last name for Car 1:");
        String lastName1 = scanner.nextLine();

        System.out.println("Enter owner's state for Car 1:");
        String state1 = scanner.nextLine();

        System.out.println("Enter registration date for Car 1 (YYYY-MM-DD):");
        @SuppressWarnings("unused")
		String registrationDateStr1 = scanner.nextLine();
        Date registrationDate1 = new Date();

        System.out.println("Enter remaining balance for Car 1:");
        double remainingBalance1 = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Enter dealership name for Car 1:");
        String dealershipName1 = scanner.nextLine();

        System.out.println("Enter license plate for Car 1:");
        String licensePlate1 = scanner.nextLine();

        
        System.out.println("Enter owner's first name for Car 2:");
        String firstName2 = scanner.nextLine();

        System.out.println("Enter owner's last name for Car 2:");
        String lastName2 = scanner.nextLine();

        System.out.println("Enter owner's state for Car 2:");
        String state2 = scanner.nextLine();

        System.out.println("Enter registration date for Car 2 (YYYY-MM-DD):");
        @SuppressWarnings("unused")
		String registrationDateStr2 = scanner.nextLine();
        Date registrationDate2 = new Date(); 

        System.out.println("Enter remaining balance for Car 2:");
        double remainingBalance2 = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Enter dealership name for Car 2:");
        String dealershipName2 = scanner.nextLine();

        System.out.println("Enter license plate for Car 2:");
        String licensePlate2 = scanner.nextLine();

        Car car1 = new Car("Cruze", "Chevrolet", 2013, "Blue", 4, 10001);
        Car car2 = new Car("Silverado", "Chevrolet", 2024, "Gray", 4, 10002);

        OwnerInfo ownerInfo1 = new OwnerInfo(firstName1, lastName1, state1, registrationDate1,
                remainingBalance1, dealershipName1, licensePlate1);

        OwnerInfo ownerInfo2 = new OwnerInfo(firstName2, lastName2, state2, registrationDate2,
                remainingBalance2, dealershipName2, licensePlate2);

        CarInventory inventory = new CarInventory(2);

        inventory.addCar(car1, ownerInfo1);
        inventory.addCar(car2, ownerInfo2);

        System.out.println("---List of Cars---");
        inventory.output();
    }
}
