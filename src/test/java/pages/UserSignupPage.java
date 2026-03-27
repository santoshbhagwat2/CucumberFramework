package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSignupPage {
    WebDriver driver;
    By N = By.xpath("//input[@name='name']");
    By E = By.cssSelector("input[type='Email'][data-qa='signup-email']");
    By s= By.cssSelector("button[data-qa='signup-button']");
    By Msg= By.xpath("//b[text()='Enter Account Information']");
    By signupLink=By.xpath("//a[text()=' Signup / Login']");


    public UserSignupPage(WebDriver d){
        driver=d;
    }

    public void singup(String name,String email){
        driver.findElement(signupLink).click();
        driver.findElement(N).sendKeys(name);
        driver.findElement(E).sendKeys(email);
        driver.findElement(s).click();
    }

    public String getMsg(){
        return driver.findElement(Msg).getText();
    }




}



