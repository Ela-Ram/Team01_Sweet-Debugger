package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfig {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); 
        }
    }
}
