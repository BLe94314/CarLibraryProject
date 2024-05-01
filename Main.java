package application;

/*
 * Project Name: Car Library Project 
 * Class Name: OwnerInfo.java
 * Author Name: Sir Winsome McMillion, Bryant Le, David Tamietto
 * Date (Last Updated): 05/01/2024
 * Description: This class uses the previous classes to display a 
 * GUI of the car rental service. 
 */

import java.util.Calendar;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    // Initialized variables
    private CarInventory inventory;
    private GridPane inventoryGrid;

    private void openRentCarStage() {
        Stage rentStage = new Stage();
        // Prevents the user from making inputs onto the primary stage when the rent
        // window is open
        rentStage.initModality(Modality.APPLICATION_MODAL);
        rentStage.setTitle("Rent a Car");
        rentStage.setResizable(false);

        Label titleLabel = new Label("Please select a car:");
        titleLabel.setStyle("-fx-font-weight: bold;");

        VBox rentLayout = new VBox(10);
        rentLayout.getChildren().add(titleLabel);
        ToggleGroup carGroup = new ToggleGroup();

        // Add radio buttons for each available car
        for (Car car : inventory.getCars()) {
            if (car != null && car.getAvailable()) {
                RadioButton radioButton = new RadioButton(car.getYear() + " " + car.getMake() + " " + car.getName());
                radioButton.setToggleGroup(carGroup);
                rentLayout.getChildren().add(radioButton);
            }
        }

        // Add a button to confirm selection
        Button rentButton = new Button("Rent");
        rentButton.setOnAction(e -> {
            // Check if the user already has a rented car
            boolean alreadyRented = false;
            for (Car car : inventory.getCars()) {
                if (car != null && !car.getAvailable()) {
                    alreadyRented = true;
                    break;
                }
            }

            // Checks to see if the user is currently renting a car
            if (alreadyRented) {
                // Show an alert that the user already has a rented car
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Already Rented");
                alert.setHeaderText("INVALID INPUT!");
                alert.setContentText("You already have a rented car. Please return it before renting another one.");
                alert.showAndWait();
            } else {
                // Proceed with renting the selected car
                RadioButton selectedRadioButton = (RadioButton) carGroup.getSelectedToggle();
                if (selectedRadioButton != null) {
                    String selectedCar = selectedRadioButton.getText();

                    for (Car car : inventory.getCars()) {
                        if (car != null && car.getAvailable()
                                && selectedCar.equals(car.getYear() + " " + car.getMake() + " " + car.getName())) {
                            car.setAvailable(false);
                            break;
                        }
                    }

                    rentStage.hide();
                    carGroup.selectToggle(null);

                    // Show the confirmation message that the user has rented a car
                    Platform.runLater(() -> {
                        Alert confirmation = new Alert(AlertType.INFORMATION);
                        confirmation.setTitle("Car Rental");
                        confirmation.setHeaderText("SUCCESS!");
                        confirmation.setContentText("You have rented: " + selectedCar);
                        confirmation.showAndWait();
                    });
                    refreshCars();

                } else {
                    // show an alert if no radio button is not selected
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Radio button was not selected!");
                    alert.setHeaderText("INVALID INPUT!");
                    alert.setContentText("Please select a car to rent.");
                    alert.showAndWait();
                }
            }
        });

        rentLayout.getChildren().add(rentButton);
        rentLayout.setAlignment(Pos.CENTER);

        Scene rentScene = new Scene(rentLayout, 300, 200);
        rentStage.setScene(rentScene);
        rentStage.showAndWait();
    }

    // Method to refresh the inventory display after returning or renting a car
    private void refreshCars() {
        // Clear existing inventory display
        if (inventoryGrid != null) {
            inventoryGrid.getChildren().clear();
        }

        Label makeCarIDLabel = new Label("ID");
        makeCarIDLabel.setStyle("-fx-font-weight: bold;");

        Label makeColumnLabel = new Label("Make");
        makeColumnLabel.setStyle("-fx-font-weight: bold;");

        Label modelColumnLabel = new Label("Model");
        modelColumnLabel.setStyle("-fx-font-weight: bold;");

        Label yearColumnLabel = new Label("Year");
        yearColumnLabel.setStyle("-fx-font-weight: bold;");

        Label colorColumnLabel = new Label("Color");
        colorColumnLabel.setStyle("-fx-font-weight: bold;");

        Label vinColumnLabel = new Label("VIN");
        vinColumnLabel.setStyle("-fx-font-weight: bold;");

        Label availableColumnLabel = new Label("Available?");
        availableColumnLabel.setStyle("-fx-font-weight: bold;");

        // Add column labels to the grid

        inventoryGrid.add(makeCarIDLabel, 0, 0);
        inventoryGrid.add(makeColumnLabel, 1, 0);
        inventoryGrid.add(modelColumnLabel, 2, 0);
        inventoryGrid.add(yearColumnLabel, 3, 0);
        inventoryGrid.add(colorColumnLabel, 4, 0);
        inventoryGrid.add(vinColumnLabel, 5, 0);
        inventoryGrid.add(availableColumnLabel, 6, 0);

        int rowIndex = 1; // Start from row 1 to leave row 0 for column labels
        for (Car car : inventory.getCars()) {
            if (car != null) {
                // Create labels for car information

                Label carIDLabel = new Label(Integer.toString(car.getCarID()));
                Label makeLabel = new Label(car.getMake());
                Label modelLabel = new Label(car.getName()); // Assuming getName() is the model name
                Label yearLabel = new Label(Integer.toString(car.getYear()));
                Label colorLabel = new Label(car.getColor());
                Label vinLabel = new Label(Integer.toString(car.getVin()));
                Label availableLabel = new Label(car.getAvailable() ? "Yes" : "No");

                // Add labels to the GridPane
                inventoryGrid.add(carIDLabel, 0, rowIndex);
                inventoryGrid.add(makeLabel, 1, rowIndex);
                inventoryGrid.add(modelLabel, 2, rowIndex);
                inventoryGrid.add(yearLabel, 3, rowIndex);
                inventoryGrid.add(colorLabel, 4, rowIndex);
                inventoryGrid.add(vinLabel, 5, rowIndex);
                inventoryGrid.add(availableLabel, 6, rowIndex);

                // Increment row index for the next car
                rowIndex++;
            }
        }
    }

    // Method to handle returning the rented car
    private void returnCars() {
        // Check if there is a rented car
        for (Car car : inventory.getCars()) {
            if (car != null && !car.getAvailable()) {
                // Update availability to "Yes"
                car.setAvailable(true);
                // Show confirmation message that car has returned successfully
                Alert confirmation = new Alert(AlertType.INFORMATION);
                confirmation.setTitle("Car Rental");
                confirmation.setHeaderText("SUCCESS!");
                confirmation.setContentText("Car returned successfully.");
                confirmation.showAndWait();
                // Refresh the inventory display to update the car's availability
                refreshCars();
                return;
            }
        }
        // If no car is currently rented, display an error message
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("No Car Rented");
        alert.setHeaderText("INVALID INPUT!");
        alert.setContentText("You are not currently renting a car.");
        alert.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) {
        // create a VBox to hold the StackPane and BorderPane
        VBox root = new VBox();

        // create a StackPane for the title bar
        StackPane titlePane = new StackPane();

        // create a label for the title
        Label titleLabel = new Label("Car Rental Program");
        titleLabel.setStyle("-fx-font-size: 20; -fx-weight: bold;");
        titleLabel.setPadding(new Insets(10));

        // create a BorderPane for the main content
        BorderPane carInfo = new BorderPane();

        // place the title in a VBox
        VBox titleBox = new VBox(10);
        titleBox.getChildren().add(titleLabel);
        titleBox.setAlignment(Pos.CENTER);

        // set the background color for the title bar
        titleBox.setStyle("-fx-background-color: lightblue; -fx-alignment: center;");

        // set the width of the titleBox to 100% of the StackPane
        titleBox.prefWidthProperty().bind(titlePane.widthProperty());

        // add the titleBox to the StackPane
        titlePane.getChildren().add(titleBox);

        // add the titlePane (StackPane) to the VBox
        root.getChildren().addAll(titlePane, carInfo);

        // create a CarInventory object with vehicles in it
        inventory = new CarInventory(6);

        // add cars to the inventory
        Car car1 = new Car(1, "Tundra", "Toyota", 2020, "Red", 4, 123456, true);
        Calendar registrationDate1 = Calendar.getInstance();
        registrationDate1.set(2020, Calendar.JANUARY, 1);
        OwnerInfo owner1 = new OwnerInfo("John", "Doe", "CA", registrationDate1, 0.0, "XYZ Motors", "ABC123");
        inventory.addCar(car1, owner1);

        Car car2 = new Car(2, "Civic", "Honda", 2018, "Blue", 4, 789012, true);
        Calendar registrationDate2 = Calendar.getInstance();
        registrationDate2.set(2018, Calendar.MARCH, 15);
        OwnerInfo owner2 = new OwnerInfo("Jane", "Smith", "NY", registrationDate2, 0.0, "ABC Autos", "DEF456");
        inventory.addCar(car2, owner2);

        Car car3 = new Car(3, "Bronco", "Ford", 2019, "Black", 4, 345678, true);
        Calendar registrationDate3 = Calendar.getInstance();
        registrationDate3.set(2019, Calendar.MAY, 20);
        OwnerInfo owner3 = new OwnerInfo("Bob", "Johnson", "TX", registrationDate3, 1500.0, "123 Cars", "GHI789");
        inventory.addCar(car3, owner3);

        Car car4 = new Car(4, "Equinox", "Chevrolet", 2017, "Silver", 4, 901234, true);
        Calendar registrationDate4 = Calendar.getInstance();
        registrationDate4.set(2017, Calendar.JULY, 10);
        OwnerInfo owner4 = new OwnerInfo("Alice", "Brown", "FL", registrationDate4, 3000.0, "XYZ Autos", "JKL012");
        inventory.addCar(car4, owner4);

        // inventory.addCar(new Car("Model 3", "Tesla", 2021, "White", 4, 567890), new
        // OwnerInfo("Michael", "Lee", "CA", new Date(2021, 9, 5), 10000.0, "Tesla
        // Motors", "MNO345"));
        // inventory.addCar(new Car("X5", "BMW", 2016, "Gray", 4, 123789), new
        // OwnerInfo("Emily", "Davis", "WA", new Date(2016, 11, 20), 5000.0, "BMW Cars",
        // "PQR678"));

        // create HBox to hold inventory information
        HBox inventoryBox = new HBox();
        inventoryBox.setPadding(new Insets(10));
        inventoryBox.setSpacing(10);

        // Create GridPane to hold inventory information
        inventoryGrid = new GridPane();
        inventoryGrid.setPadding(new Insets(10));
        inventoryGrid.setHgap(15);
        inventoryGrid.setVgap(5);

        // Add column labels
        Label makeCarIDLabel = new Label("ID");
        makeCarIDLabel.setStyle("-fx-font-weight: bold;");

        Label makeColumnLabel = new Label("Make");
        makeColumnLabel.setStyle("-fx-font-weight: bold;");

        Label modelColumnLabel = new Label("Model");
        modelColumnLabel.setStyle("-fx-font-weight: bold;");

        Label yearColumnLabel = new Label("Year");
        yearColumnLabel.setStyle("-fx-font-weight: bold;");

        Label colorColumnLabel = new Label("Color");
        colorColumnLabel.setStyle("-fx-font-weight: bold;");

        Label vinColumnLabel = new Label("VIN");
        vinColumnLabel.setStyle("-fx-font-weight: bold;");

        Label availableColumnLabel = new Label("Available?");
        availableColumnLabel.setStyle("-fx-font-weight: bold;");

        // Add column labels to a specific area on the grid
        inventoryGrid.add(makeCarIDLabel, 0, 0);
        inventoryGrid.add(makeColumnLabel, 1, 0);
        inventoryGrid.add(modelColumnLabel, 2, 0);
        inventoryGrid.add(yearColumnLabel, 3, 0);
        inventoryGrid.add(colorColumnLabel, 4, 0);
        inventoryGrid.add(vinColumnLabel, 5, 0);
        inventoryGrid.add(availableColumnLabel, 6, 0);

        // Add each car's information to the GridPane
        int rowIndex = 1; // Start from row 1 to leave row 0 for column labels
        for (Car car : inventory.getCars()) {
            if (car != null) {
                // Create labels for car information
                Label carIDLabel = new Label(Integer.toString(car.getCarID()));
                Label makeLabel = new Label(car.getMake());
                Label modelLabel = new Label(car.getName()); // Assuming getName() is the model name
                Label yearLabel = new Label(Integer.toString(car.getYear()));
                Label colorLabel = new Label(car.getColor());
                Label vinLabel = new Label(Integer.toString(car.getVin()));
                Label availableLabel = new Label(car.getAvailable() ? "Yes" : "No");

                // Add labels to the GridPane
                inventoryGrid.add(carIDLabel, 0, rowIndex);
                inventoryGrid.add(makeLabel, 1, rowIndex);
                inventoryGrid.add(modelLabel, 2, rowIndex);
                inventoryGrid.add(yearLabel, 3, rowIndex);
                inventoryGrid.add(colorLabel, 4, rowIndex);
                inventoryGrid.add(vinLabel, 5, rowIndex);
                inventoryGrid.add(availableLabel, 6, rowIndex);

                // Increment row index for the next car
                rowIndex++;
            }
        }

        // add grid to inventoryBox and align
        inventoryBox.getChildren().addAll(inventoryGrid);
        inventoryBox.setAlignment(Pos.CENTER);

        // set the inventoryBox (HBox) as the center of the BorderPane
        carInfo.setCenter(inventoryBox);

        // create the main scene
        Scene scene = new Scene(root, 460, 280);

        // Creates a button to return a car
        Button returnButton = new Button("Return Car");
        returnButton.setOnAction(e -> returnCars());

        // Creates a button to rent a car
        Button rentButton = new Button("Rent a Car");
        rentButton.setOnAction(e -> openRentCarStage());

        // Create an HBox to hold the return and rent buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(returnButton, rentButton);
        buttonBox.setAlignment(Pos.CENTER);

        carInfo.setBottom(buttonBox);

        // set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Car Rental Program");
        primaryStage.setMinHeight(280);
        primaryStage.setMinWidth(460);
        primaryStage.setMaxHeight(280);
        primaryStage.setMaxWidth(460);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
