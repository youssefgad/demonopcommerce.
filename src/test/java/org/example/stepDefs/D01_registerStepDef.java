package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void go_to_register()
    {
        register.register.click();
    }

    @When("user select gender type")
    public void userSelectGenderType() throws InterruptedException {
        register.selectGenderFemale.click();
        Thread.sleep(1000);
        register.selectGenderMale.click();
    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void userEnterFirstNameAndLastName()  throws InterruptedException {
        register.enterFirstName.sendKeys("automation100");

        Thread.sleep(1000);

        register.enterLastName.sendKeys("tester100");
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        register.selectDay.click();
        register.selectDay.findElement(By.cssSelector("option[value=\"2\"]")).click();

        register.selectMonth.click();
        register.selectMonth.findElement(By.cssSelector("option[value=\"6\"]")).click();

        register.selectYear.click();
        register.selectYear.findElement(By.cssSelector("option[value=\"1991\"]")).click();
    }

    @And("user enter email \"test@example.com\" field")
    public void userEnterEmailField() {
        register.enterEmail.sendKeys("test@example93.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void userFillsPasswordFields() throws InterruptedException {
        register.enterPassword.sendKeys("P@ssw0rd");

        register.ConfirmPassword.sendKeys("P@ssw0rd");
        Thread.sleep(1000);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.clickRegisterButton.submit();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        register.displaySuccessMessage.findElements(By.className("result"));

        //Assertion
        SoftAssert soft = new SoftAssert();

        String expectedResult = "Your registration completed";
        String actualResult = register.displaySuccessMessage.getText();
        soft.assertTrue(actualResult.contains(expectedResult));

        String expectedColor = "rgba(76, 177, 124, 1)";
        String actualColor = register.displaySuccessMessage.getCssValue("color");
        soft.assertTrue(actualColor.contains(expectedColor));

        soft.assertAll();

    }
}
