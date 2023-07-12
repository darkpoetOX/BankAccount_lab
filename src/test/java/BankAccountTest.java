import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount("james","doe", LocalDate.of(1905,11,5),"54899967","current",-1600000.0);
    }
    @Test
    public void canGetFirstName(){
        String result = bankAccount.getFirstName();
        String expected = "james";
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void canGetLastName(){
        String result = bankAccount.getLastName();
        String expected = "doe";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetDateOfBirth(){
        LocalDate result = bankAccount.getDateOfBirth();
        LocalDate expected = LocalDate.of(1905, 11, 5);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetAccountNumber(){
        String result = bankAccount.getAccountNumber();
        String expected = "54899967";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetBalance(){
        double result = bankAccount.getBalance();
        double expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetFirstName(){
        bankAccount.setFirstName("jonathan");
        String result = bankAccount.getFirstName();
        String expected = "jonathan";
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void canSetLastName(){
        bankAccount.setLastName("yates");
        String result = bankAccount.getLastName();
        String expected = "yates";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetDateOfBirth(){
        bankAccount.setDateOfBirth(LocalDate.of(1995,6,2));
        LocalDate result = bankAccount.getDateOfBirth();
        LocalDate expected = LocalDate.of(1995, 6, 2);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetAccountNumber(){
        bankAccount.setAccountNumber("59999996");
        String result = bankAccount.getAccountNumber();
        String expected = "59999996";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetBalance(){
        bankAccount.setBalance(1000000.0);
        double result = bankAccount.getBalance();
        double expected = 1000000.0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canDeposit(){
        bankAccount.deposit(555000.0);
        double result = bankAccount.getBalance();
        double expected = 555000.0;
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void canSetAccountType() {
        bankAccount.setAccountType("current");
        String result = bankAccount.getAccountType();
        String expected = "current";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetAccountType() {
        String result = bankAccount.getAccountType();
        String expected = "current";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetOverdraft() {
        bankAccount.setOverdraft(-2000);
        double result = bankAccount.getOverdraft();
        double expected = -2000;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetOverdraft() {
        double result = bankAccount.getOverdraft();
        double expected = -1600000;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetWithdrawalWithinOverdraft() {
        double result = bankAccount.getBalance();
        double expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetWithdrawalPastOverdraft() {
        // Try to withdraw an amount beyond overdraft
        bankAccount.withdrawal(2000000);

        // Verify the initial balance
        double result = bankAccount.getBalance();
        double expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canPayInterest() {
        // Deposit an initial amount
        bankAccount.deposit(7000);

        // Calculate and pay interest
        bankAccount.payInterest();

        // Verify the updated balance after interest payment
        double result = bankAccount.getBalance();
        double expected = 7700; // Assuming 5% interest rate applied to the initial deposit of 1000
        assertThat(result).isEqualTo(expected);
    }


}
