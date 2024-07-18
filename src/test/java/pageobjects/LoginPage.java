package pageobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class LoginPage extends BasePage {

    private static final ObjectMapper mapper = new ObjectMapper();

    @FindBy(css = "input[name='username']")
    private WebElementFacade usernameTf;

    @FindBy(css = "input[name='password']")
    private WebElementFacade passwordTf;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    private WebElementFacade loginBtn;

    @FindBy(css = "div[class='oxd-alert oxd-alert--error']")
    private WebElementFacade errorMessageLoginFailed;

    /* BING REWARD  */
    @FindBy(xpath = "//*[@id=\"id_l\"]")
    private WebElementFacade clickLogin;

    @FindBy(css = "input[type='email']")
    private WebElementFacade emailBing;

    @FindBy(id = "idSIButton9")
    private WebElementFacade buttonNextUsername;

    @FindBy(css = "input[type='submit'][id='idSIButton9']")
    private WebElementFacade buttonNextPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/form/div[3]/div[2]/div/div[2]/button")
    private WebElementFacade buttonNextYes;

    @FindBy(css = "input[type='password']")
    private WebElementFacade passBing;

    @FindBy(xpath = "//*[@id=\"sb_form_q\"]")
    private WebElementFacade searchbox;

    @FindBy(xpath = "//*[@id=\"sb_form_q\"]")
    private WebElementFacade searchbox2;

    /**************************/


    public void inputUsername(){
        waitFor(ExpectedConditions.visibilityOf(usernameTf));
        usernameTf.sendKeys(BaseTest.getValidUser());
    }

    public void inputPassword(){
        passwordTf.sendKeys(BaseTest.getValidPassword());
    }

    public void clickOnLogin(){
        loginBtn.click();

    }


    public void inputInvalidUsername() {
        usernameTf.sendKeys(BaseTest.getInValidUser());
    }

    public void inputInvalidPassword() {
        passwordTf.sendKeys(BaseTest.getInValidPassword());
    }

    public boolean invalidCredentials(String errorMessage) {
        return errorMessageLoginFailed.getText().toLowerCase().contains(errorMessage.toLowerCase());
    }

    /* BING REWARD */

    public void userClickLogin() {
        try {

            Thread.sleep(5000);

        }catch (Exception e){
            e.printStackTrace();
        }
        clickLogin.click();
        try {

            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void inputEmail(String email) {
        try {

            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }

        emailBing.sendKeys(email);
        waitFor(ExpectedConditions.elementToBeClickable(buttonNextUsername));
        buttonNextUsername.click();

    }

    public void inputPasswordBing(String password) {
        try {

            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }

        passBing.typeAndEnter(password);

        try {

            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }


        waitFor(ExpectedConditions.elementToBeClickable(buttonNextYes));
        buttonNextYes.click();

//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.delay(300);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            robot.delay(300);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
    }

    public void

    inputBingReward()
    {
        List<String> keyword = ListKeywordBingReward();
        log.info("Keyword Size : " + keyword);

        firstSearch(keyword.get(0));
        secondSearch(keyword);
    }

    public List<String> ListKeywordBingReward() {
        List<String> result = new ArrayList<>();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://random-word-api.herokuapp.com/word?number=30"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            result = Arrays.stream(response.body().split(",")).toList();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<String> ListKeywordBingReward2() {
        List<String> result = new ArrayList<>();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://random-word-api.herokuapp.com/word?number=30"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonNode resp = mapper.readTree(response.body());
            result = mapper.readerForListOf(String.class).readValue(resp);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void firstSearch (String firstKeyword)  {

        try {
            Thread.sleep(5000);
        } catch (Exception e){
            e.printStackTrace();
        }


//        waitFor(ExpectedConditions.visibilityOf(searchbox));
        searchbox.typeAndEnter(firstKeyword);
//        typeInto(searchbox, firstKeyword);

        try {

            Thread.sleep(1000);
            

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(300);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(300);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        try {

            Thread.sleep(
                    5000);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void secondSearch(List<String> keywords){

        for ( String keyword : keywords)
        {

            waitFor(ExpectedConditions.visibilityOf(searchbox2));
            searchbox2.typeAndEnter(keyword);

            try {

                Thread.sleep(1000);

            }catch (Exception e){
                e.printStackTrace();
            }

//            try {
//                Robot robot = new Robot();
//                robot.keyPress(KeyEvent.VK_ENTER);
//                robot.delay(300);
//                robot.keyRelease(KeyEvent.VK_ENTER);
//                robot.delay(300);
//            } catch (AWTException e) {
//                e.printStackTrace();
//            }

            try {
                Thread.sleep(

                        5000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
