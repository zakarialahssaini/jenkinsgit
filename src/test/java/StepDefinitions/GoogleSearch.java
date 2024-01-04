package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearch {
	 WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
		 WebDriverManager.chromedriver().browserVersion("120.0.6099.63").setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		System.out.println("Inside Step - browser is open");
	    
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 driver.navigate().to("https://www.google.com/?hl=fr");
		System.out.println("Inside Step - user is on google search page");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions 
	
		driver.findElement(By.name("q")).sendKeys("Booking");
		System.out.println("Inside Step - user enters a text in search box");
	}

	@And("hits enter")
	public void hits_enter() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("Inside Step - hits enter");
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Booking.com - Site Officiel");
		System.out.println("Inside Step - user is navigated to search results");
		driver.close();
	}
}