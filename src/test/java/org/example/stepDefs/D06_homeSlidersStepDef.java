package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("user click on first slider")
    public void UserClickOnFirstSlider() throws InterruptedException {

        homePage.NokiaSlider.click();
        Thread.sleep(1000);
    }

    @Then("Verify user redirect to this url nokia-lumia{int}")
    public void verifyUserRedirectToThisUrlNokiaLumia() {
        String ActualURL =driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(ActualURL,expectedURL);

    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() throws InterruptedException {
        Thread.sleep(4000);

        homePage.IphoneSlider.click();

    }

    @Then("Verify user redirect to Iphone URL")
    public void verifyUserRedirectToIphoneURL() {
        String ActualURL =driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(ActualURL,expectedURL);

    }
}

