package cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageobjects.LoginPage;

public class LoginSteps {

    @Steps
    LoginPage loginPage;


    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage.openOrangeHrmWeb();
    }

    @When("user enters a valid username")
    public void userEntersAValidUsername() {
        loginPage.inputUsername();
    }

    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        loginPage.inputPassword();
    }

    @And("clicks the Login button")
    public void clicksTheLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("user should be redirected to the {string} page")
    public void userShouldBeRedirectedToTheDashboardPage(String title) {
        Assert.assertTrue(loginPage.verifyMenu(title));
    }

    @When("user enters a invalid username")
    public void userEntersAInvalidUsername() {

        loginPage.inputInvalidUsername();

    }

    @And("user enters a invalid password")
    public void userEntersAInvalidPassword() {
        loginPage.inputInvalidPassword();
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        Assert.assertTrue(loginPage.invalidCredentials(errorMessage));
    }

    @And("user enters click")
    public void userEntersClick() {

    }

    @And("user click login")
    public void userClickLogin() {
        loginPage.userClickLogin();
    }

    @And("user input email {string}")
    public void userInputEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        loginPage.inputPasswordBing(password);
    }

    @And("user input bing reward")
    public void userInputBingReward() {
        loginPage.inputBingReward();
//        loginPage.inputKeywordBingReward();
    }


    @Then("bing reward success")
    public void bingRewardSuccess() {

        try{

            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
