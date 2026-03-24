package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {
    private static final Logger log = LogManager.getLogger(LoginSteps.class);
    LoginPage page = new LoginPage(DriverFactory.getDriver());
    @Given("user is on login page")
    public void open() {
        log.info("Opening page");
        DriverFactory.getDriver().get("https://the-internet.herokuapp.com/login");
    }

    @When("user enters {string} and {string}")
    public void login(String u, String p) {
        page.login(u, p);
    }

    @Then("user should see success message")
    public void verify() {
        log.info(page.getMsg());
    }
}