package StepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;

public class Hooks {
    private static WebDriver driver;
    @Before
    public void setUpDriver() {
        WebDriverManager.chromedriver().browserVersion("120.0.6099.63").setup();
        driver = new ChromeDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                captureScreenshot(scenario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private void captureScreenshot(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")
                    + "_" + System.currentTimeMillis() + ".png";

            scenario.log("Scenario failed! Capturing screenshot: " + screenshotName);
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            System.out.println("Screenshot size: " + screenshot.length);
            Allure.addAttachment("Scenario Screenshot", new ByteArrayInputStream(screenshot));
            System.out.println("I'm working man");
            scenario.attach(screenshot, "image/png", "Scenario Screenshot");
            System.out.println("I'm working man1");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}