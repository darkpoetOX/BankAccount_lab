import java.time.LocalDate;

public class BankAccount {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String accountNumber;
    private double balance;
    private String accountType;
    private double overdraft;

    public BankAccount(String putFirstName,String putLastName, LocalDate putDateOfBirth, String putAccountNumber, String putAccountType, double putOverdraft){
        this.firstName = putFirstName;
        this.lastName = putLastName;
        this.dateOfBirth = putDateOfBirth;
        this.accountNumber = putAccountNumber;
        this.balance = 0;
        this.accountType = putAccountType;
        this.overdraft = putOverdraft;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public double getBalance() {
        return this.balance;
    }

    public void setFirstName(String putFirstName) {
        this.firstName = putFirstName;
    }

    public void setLastName(String putLastName) {
        this.lastName = putLastName;
    }

    public void setDateOfBirth(LocalDate putDateOfBirth) {
        this.dateOfBirth = putDateOfBirth;
    }
    public void setAccountNumber(String putAccountNumber) {
        this.accountNumber = putAccountNumber;
    }

    public void setBalance(double putBalance) {
        this.balance = putBalance;
    }
    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String putAccountType) {
        this.accountType = putAccountType;
    }

    public double getOverdraft() {
        return this.overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String withdrawal(double amount) {
        if (balance - amount >= overdraft) {
            balance -= amount;
            return "You have withdrawn successfully. Balance now: " + balance;
        } return "Not enough money. Withdrawal denied.";
    }

    public void payInterest() {
        double interestRate = 0.0;
        if (accountType.equals("savings")) {
            interestRate = 0.6; // 60% interest for savings account
        } else if (accountType.equals("current")) {
            interestRate = 0.1; // 10% interest for current account
        }
        double interest = balance * interestRate;
        balance += interest;
    }


}
