package steps;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {

	public static WebDriver driver = null;

	@Given("^I want to open a chrome browser$")
	public void i_want_to_open_a_chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
	    Logger.getLogger("").setLevel(Level.OFF);
	    driver = new ChromeDriver();
	    
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); 
	}

	@Given("^navigate to Google$")
	public void navigate_to_Google() throws Throwable {
	    driver.get("http://www.google.ca");
	}

	@Then("^I verify the url is https://www\\.fanshawec\\.ca/$")
	public void i_verify_the_url_is_https_www_fanshawec_ca() throws Throwable {
		assertEquals(driver.getCurrentUrl(), "https://www.fanshawec.ca");
	}

	@When("^I search for Software and Information Systems Testing$")
	public void i_search_for_Software_and_Information_Systems_Testing() throws Throwable {
		//find the search box by name
        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("Software and Information Systems Testing");
	}

	@Then("^I verify the title is Software and Information Systems Testing$")
	public void i_verify_the_title_is_Software_and_Information_Systems_Testing() throws Throwable {
		//is the title correct?
   		String actualTitle = driver.getTitle();
   		assertEquals(actualTitle, "Software and Information Systems Testing | Fanshawe College");
	}

	@Then("^I verify the url is Fanshawe College$")
	public void i_verify_the_url_is_Fanshawe_College() throws Throwable {
		//check we landed on https://www.fanshawec.ca/
   		assertEquals(driver.getCurrentUrl(), "https://www.fanshawec.ca");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		 //find the search box by name
        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys(arg1);
        
	}

	@Then("^I verify the title is \"([^\"]*)\"$")
	public void i_verify_the_title_is(String arg1) throws Throwable {
		String actualTitle = driver.getTitle();
   		assertEquals(actualTitle, arg1);
	}

	@Then("^I verify the url is \"([^\"]*)\"$")
	public void i_verify_the_url_is(String arg1) throws Throwable {
		//check we landed on https://www.fanshawec.ca/
   		assertEquals(driver.getCurrentUrl(), arg1);
	}
	
	@When("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		//find the search button by name
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.submit();
	}

	@When("^I click the first result$")
	public void i_click_the_first_result() throws Throwable {
		//find the first result be tag
        //google tags the first result with <h3></h3>
        WebElement firstResult = driver.findElement(By.tagName("h3"));
        
        //click the first result
   		firstResult.click();
	}
	
	@Then("^I close the chrome browser$")
	public void i_close_the_chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

	//#region 
	StringBuilder sb = new StringBuilder();
    static Integer total = 0;
//    public CheckoutSteps(){
//        sb.append("Items: ");
//    }

static Map<String, Integer[]> checkoutItems = new HashMap<String, Integer[]>();

@Given("^the checkout system has the following pricing rules$")
public void the_checkout_system_has_the_following_pricing_rules() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("the_checkout_system_has_the_following_pricing_rules");
}

@When("the cashier scans the following items in any order: {string} with unit price of {int}. Posible specialPrice is {string}")
public void the_cashier_scans_the_following_items_in_any_order_with_unit_price_of_possible_special_price(String shoppedItem, Integer unitPrice, String specialPrice) {
    // Write code here that turns the phrase above into concrete actions
//	Integer[] skuAndPrice = new Integer(0)
	if(checkoutItems.containsKey(shoppedItem)) {
        String[] discount = new String[2];
		if(specialPrice != null && !specialPrice.isBlank()) {
			discount = specialPrice.split("for");
		}
		//checkoutItems.
//		checkoutItems.computeIfPresent(shoppedItem,(k,v) -> v[0] += 1, unitPrice);
	}else {
//		checkoutItems.put(shoppedItem, unitPrice);
	}
    System.out.println(String.format("the_cashier_scans_the_following_items: %s, which has price of %s.",shoppedItem, unitPrice));
}

@Then("the total price should be {int} cents")
public void the_total_price_should_be_cents(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
   
//    for (Map.Entry<String, Integer> entry : checkoutItems.entrySet()) {
//        sb.append(String.format("%s,", entry.getKey()));
//        total += entry.getValue();
//    }
    System.out.println(String.format("The total amount value is %s", total));
}

	//#endregion
}
