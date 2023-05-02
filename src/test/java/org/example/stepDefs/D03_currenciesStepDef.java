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

public class D03_currenciesStepDef {
    P03_homePage currencyList = new P03_homePage();
    @Given("user click on currency dropdown list and Select Euro currency")
    public void userClickOnCurrencyDropdownListAndSelectEuroCurrency() {
        currencyList.currencyList.click();
        currencyList.EURO.click();
    }

    @Then("shown on the 4 products displayed in Home page")
    public void products_displayed() {
        int size = driver.findElements(By.xpath("//span[@class='price actual-price']")).size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            String text = driver.findElements(By.xpath("//span[@class='price actual-price']")).get(i).getText();
            Assert.assertTrue(text.contains("€"));

        }
    }

}
