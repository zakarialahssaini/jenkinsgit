package Object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectCucumber {

    WebDriver driver;

    By email = By.id("email");
    By password = By.id("pass");
    By login = By.xpath("//*[@id='send2']/span");

    public ObjectCucumber(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email1) {
        driver.findElement(email).sendKeys(email1);
    }

    public void enterPassword(String password1) {
        driver.findElement(password).sendKeys(password1);
    }

    public void loginButton() {
        driver.findElement(login).click();
    }
}