package StepDefinations;

import Base.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginStepDefinitions extends Setup {
    LoginPage loginPage;

    @Given("User visited the site")
    public void user_visited_the_site() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User inputs valid {string} and invalid {string}")
    public void user_inputs_valid_and_invalid(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.doLogin(username, password);
    }

    @Then("User can see error message")
    public void user_can_see_error_message() {
        String error = loginPage.lblValidationError.getText();
        Assert.assertTrue(error.contains("Invalid credentials"));
    }
    @When("User inputs invalid {string} and valid {string}")
    public void user_inputs_invalid_and_valid(String username, String password){
        loginPage=new LoginPage(driver);
        loginPage.doLogin(username, password);
    }
    @Then("User can see error message again")
    public void user_can_see_error_message_again() {
        String error = loginPage.lblValidationError.getText();
        Assert.assertTrue(error.contains("Invalid credentials"));
    }
    @When("User inputs blank {string} and blank {string}")
    public void user_inputs_blank(String username, String password){
        loginPage=new LoginPage(driver);
        loginPage.doLogin(username, password);
    }
    @Then("User can see error message show again")
    public void user_can_see_error_message_show_again() {
        String error = loginPage.lblRequired.get(0).getText();
        Assert.assertTrue(error.contains("Required"));
        String error1 = loginPage.lblRequired.get(1).getText();
        Assert.assertTrue(error1.contains("Required"));
    }
    @When("User inputs valid {string} and valid {string}")
    public void user_inputs_valid_and_valid(String username, String password){
        loginPage=new LoginPage(driver);
        loginPage.doLogin(username, password);
    }
    @Then("User can see dashboard page")
    public void user_can_see_dashboard_page() {
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("dashboard"));
    }
}
