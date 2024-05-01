package application;

/*
 * Project Name: Car Library Project 
 * Class Name: OwnerInfo.java
 * Author Name: Sir Winsome McMillion
 * Date (Last Updated): 05/01/2024
 * Description: The purpose of this class is to have the user input the 
 * owner operator's information for both car 1 & car 2. 
 * Information gathered from the user consists of the following: 
 * First Name, Last Name, State, Registration Date, Remaining Balance, 
 * Dealership Name, and License Plate.
 */

import java.util.Calendar;

public class OwnerInfo {

    // Owner's information
    private String firstName;
    private String lastName;
    private String state;
    private Calendar registrationDate;
    private double remainingBalance;
    private String dealershipName;
    private String licensePlate;

    // Constructor for OwnerInfo
    public OwnerInfo(String firstName, String lastName, String state, Calendar registrationDate,
            double remainingBalance, String dealershipName, String licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.registrationDate = registrationDate;
        this.remainingBalance = remainingBalance;
        this.dealershipName = dealershipName;
        this.licensePlate = licensePlate;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
