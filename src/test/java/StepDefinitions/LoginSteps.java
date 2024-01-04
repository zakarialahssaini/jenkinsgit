package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import Object.ObjectCucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


 

public class LoginSteps {

    WebDriver driver;
    ObjectCucumber loginpage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        WebDriverManager.chromedriver().browserVersion("120.0.6099.63").setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        System.out.println("Inside Step - user is on the login page");

        // Pass the driver instance to the LoginPage constructor
        loginpage = new ObjectCucumber(driver);
    }

    @When("the user enters invalid information {string} and {string}")
    public void the_user_enters_email_and_password(String email, String password) {
        loginpage.enterEmail(email);
        loginpage.enterPassword(password);
        System.out.println("Inside Step - user enters email and password");
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginpage.loginButton();
        System.out.println("Inside Step - user clicks login button");
    }

    @Then("the user should not navigate to the home page")
    public void the_user_should_not_navigate_to_the_home_page() {
        // Close the WebDriver session
        driver.quit();
        System.out.println("Inside Step - user should not navigate to home page");
    }
    @Given("the user is on the login page for login")
    public void the_user_is_on_the_login_page_for_login() {
        WebDriverManager.chromedriver().browserVersion("120.0.6099.63").setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        System.out.println("Inside Step - user is on the login page");

        // Pass the driver instance to the LoginPage constructor
        loginpage = new ObjectCucumber(driver);
    }

    @When("the user enters valid information {string} and {string}")
    public void the_user_enters_valid_information(String email_correcte, String password_correcte) {
        loginpage.enterEmail(email_correcte);
        loginpage.enterPassword(password_correcte);
        System.out.println("Inside Step - user enters email and password");
    }

    @And("the user clicks the login button for login")
    public void the_user_clicks_the_login_button_for_login() {
        loginpage.loginButton();
        System.out.println("Inside Step - user clicks login button");
    }

    @Then("the user should navigated to the home page")
    public void the_user_should_navigated_to_the_home_page() {
        // Close the WebDriver session
        driver.quit();
        System.out.println("Inside Step - user should not navigate to home page");
    }
}