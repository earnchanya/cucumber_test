package ku.atm;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefATM {

    ATM atm;
    Bank bank;
    boolean validLogin;

    @Before
    public void init() {
        bank = new Bank();
        atm = new ATM(bank);
    }

    @Given("a customer with id (\\d+) and pin (\\d+) exists")
    public void a_customer_with_id_and_pin_exists(int id, int pin) {
        bank.addCustomer(new Customer(id, pin));
    }

    @Given("a customer with id (\\d+) and pin (\\d+) with balance (.*) exists")
    public void a_customer_with_id_and_pin_with_balance_exists(int id, int pin, double balance) {
        bank.addCustomer(new Customer(id, pin, balance));
    }

    @When("I login to ATM with id (\\d+) and pin (\\d+)")
    public void i_login_to_ATM_with_id_and_pin(int id, int pin) {
        validLogin = atm.validateCustomer(id, pin);
    }

    @Then("I can login")
    public void i_can_login() {
        assertTrue(validLogin);
    }

    @Then("I cannot login")
    public void i_cannot_login() {
        assertFalse(validLogin);
    }

    @When("I deposit (.*) to my account")
    public void i_deposit_to_my_account(double amount) {
        atm.deposit(amount);
    }

    @Then("my account balance is (.*)")
    public void my_account_balance_is(double balance) {
        assertEquals(balance, atm.getBalance());
    }
}