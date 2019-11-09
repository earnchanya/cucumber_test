package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeepTrackStepdefs {

    private ProductInventory inventory;
    private Search search;

    @Before
    public void setup() {
        inventory = new ProductInventory();
        search = new Search();
    }

    @Given("a product (.+) with ID (.+) exists")
    public void a_product_with_ID_exists(String name, int ID) {
        inventory.addProduct(name,ID);
    }

    @When("I search (.+) with ID (.+)")
    public void i_search_with_ID(int ID) {
        Product prod = inventory.checkProduct(ID);
        search.addItem(prod);
    }

    @Then("The quantity remain product are (.+)")
    public void total_should_be(int total) {
        assertShow(search.coiuntTotal());
    }
}
