package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        driver.set(new ChromeDriver()); // Selenium Manager handles driver automatically
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}