package steps;

import io.cucumber.java.en.*;

public class CheckoutSteps {

    
//#region Gherkin Testing
@Given("the checkout system is initialized with pricing rules")
public void the_checkout_system_is_initialized_with_pricing_rules() {
    System.out.println("Executed by cucumber -"+ "the_checkout_system_is_initialized_with_pricing_rules");
}
@When("an item with SKU {string} is scanned")
public void an_item_with_sku_is_scanned(String string) {
    System.out.println("Executed by cucumber -"+ "an_item_with_sku_is_scanned");
}
@Then("the total price should be {string}")
public void the_total_price_should_be(String string) {
    System.out.println("Executed by cucumber-"+ "the_total_price_should_be");
}
//================

@When("{string} items with SKU {string} are scanned")
public void items_with_sku_are_scanned(String string, String string2) {
    System.out.println("Executed by cucumber -"+ "items_with_sku_are_scanned");
}


//================

@When("items with SKUs {string} are scanned")
public void items_with_sk_us_are_scanned(String string) {
    System.out.println("Executed by cucumber -"+ "items_with_sk_us_are_scanned");
}
//==================

    @Given("the checkout system is initialized with initial pricing rules")
    public void the_checkout_system_is_initialized_with_initial_pricing_rules() {
        System.out.println("Executed by cucumber -"+ "the_checkout_system_is_initialized_with_initial_pricing_rules");
    }
    @When("a set of new pricing rules is provided")
    public void a_set_of_new_pricing_rules_is_provided() {
        System.out.println("Executed by cucumber -"+ "a_set_of_new_pricing_rules_is_provided");
    }
    @When("items are scanned according to the new pricing rules")
    public void items_are_scanned_according_to_the_new_pricing_rules() {
        System.out.println("Executed by cucumber -"+ "items_are_scanned_according_to_the_new_pricing_rules");
    }

    //=============
    
//#endregion

}
