package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.UserSignupPage;
import utils.DriverFactory;

public class SignupSteps {
    private static final Logger log = LogManager.getLogger(SignupSteps.class);
    UserSignupPage signuppage = new UserSignupPage(DriverFactory.getDriver());
    @Given("user is on home page")
    public void open() {
        log.info("Opening Home page");
        DriverFactory.getDriver().get("https://automationexercise.com/");
    }

    @When("user enters signup name {string} and email {string}")
    public void singup(String N, String E) {
        signuppage.singup(N, E);}
    @Then("user should see signup success message")
    public void verify2() {
        log.info(signuppage.getMsg());
    }
}
