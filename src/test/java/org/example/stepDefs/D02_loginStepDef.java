package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    @Given("user go to login page")
    public void UserGoToLoginPage() {
        login.login.click();
    }


    @When("user login with \"valid\" \"test@example.com\"")
    public void user_LoginWith() {
        login.email.sendKeys("test@example93.com");
    }

    @And("user login with \"valid\"\"P@ssw0rd\"")
    public void userLoginWith() {
        login.Password.sendKeys("P@ssw0rd");
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton.submit();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();

        System.out.println(driver.getCurrentUrl());
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        String expectedResult = "My account";
        String actualResult = login.disableMyaccountTab.getText();
        soft.assertTrue(actualResult.contains(expectedResult));

        soft.assertAll();
    }

    @Given("user go to the login page")
    public void userGoToTheLoginPage() {
        login.login.click();
    }
    @When("user login with \"invalid\" \"wrong@example.com\"")
    public void userLoginWithInvalid() {
        login.email.sendKeys("wrong@example.com");
    }
    @And("user login with \"invalid\"\"P@ssw0rd\"")
    public void userLogin_With() {
        login.Password.sendKeys("P@ssw0rd");
    }
    @And("user press on the login button")
    public void userPressOnTheLoginButton() {
        login.loginButton.submit();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        String ExpectedMessage="Login was unsuccessful. Please correct the errors and try again";
        soft.assertTrue(login.Errormessage.getText().contains(ExpectedMessage));


        // color
        String expectedColor = "rgba(228, 67, 75, 1)";
        String actualColor = login.Errormessage.getCssValue("color");
        System.out.println(actualColor);
        soft.assertTrue(actualColor.contains(expectedColor));

        soft.assertAll();
    }



}
