import java.util.Date;

public class OwnerInfo {
    // Owner's information
    private String firstName;
    private String lastName;
    private String state;
    private Date registrationDate;
    private double remainingBalance;
    private String dealershipName;
    private String licensePlate;

    // Constructor for OwnerInfo
    public OwnerInfo(String firstName, String lastName, String state, Date registrationDate,
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
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

