package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By u = By.id("username");
    By p = By.id("password");
    By btn = By.cssSelector("button[type='submit']");
    By msg = By.id("flash");

    public LoginPage(WebDriver d) {
        driver = d;
    }

    public void login(String user, String pass) {
        driver.findElement(u).sendKeys(user);
        driver.findElement(p).sendKeys(pass);
        driver.findElement(btn).click();
    }

    public String getMsg() {
        return driver.findElement(msg).getText();
    }
}