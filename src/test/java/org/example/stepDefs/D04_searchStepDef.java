package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;
import java.util.List;
import org.testng.asserts.SoftAssert;


public class D04_searchStepDef {
    P03_homePage homePage= new P03_homePage ();
    @When("user search for book")
    public void UserSearchForBook(){
        homePage.search.sendKeys("book");
        homePage.search.sendKeys(Keys.ENTER);
    }

    @Then("each result contains the search word book")
    public void eachResultContainsTheSearchWordBook() {
        SoftAssert soft = new SoftAssert();

        int actualResult = driver.findElements(By.className("item-box")).size();
        System.out.println("result : "+ actualResult);
        List<WebElement> books = driver.findElements(By.className("item-box"));
        for (int i=1; i<=books.size(); i++)
        {
            String actualString= books.get(1).getText().toLowerCase();
            soft.assertTrue(actualString.contains("book"));
            soft.assertAll();
        }

    }

    @When("user search for laptop")
    public void userSearchForLaptop() {
        homePage.search.sendKeys("laptop");
        homePage.search.sendKeys(Keys.ENTER);
    }

    @Then("each result contains the search word laptop")
    public void eachResultContainsTheSearchWordLaptop() {
        SoftAssert soft = new SoftAssert();

        int actualResult = driver.findElements(By.className("item-box")).size();
        System.out.println("result : "+ actualResult);
        List<WebElement> laptops = driver.findElements(By.className("item-box"));
        for (int i=1; i<=laptops.size(); i++)
        {
            String actualString= laptops.get(1).getText().toLowerCase();
            soft.assertTrue(actualString.contains("laptop"));
            soft.assertAll();

        }
    }

    @When("user search for nike")
    public void userSearchForNike() {
        homePage.search.sendKeys("nike");
        homePage.search.sendKeys(Keys.ENTER);
    }

    @Then("each result contains the search word nike")
    public void eachResultContainsTheSearchWordNike() {
        SoftAssert soft = new SoftAssert();

        int actualResult = driver.findElements(By.className("item-box")).size();
        System.out.println("result : "+ actualResult);
        List<WebElement> nike = driver.findElements(By.className("item-box"));
        for (int i=1; i<=nike.size(); i++)
        {
            String actualString= nike.get(1).getText().toLowerCase();
            soft.assertTrue(actualString.contains("nike"));
            soft.assertAll();

        }

    }

    @When("user search for items by SKU")
    public void userSearchForItemsBySKU() {
        homePage.search.sendKeys("AP_MBP_13");
        homePage.search.sendKeys(Keys.ENTER);
        homePage.productTitle.click();
    }

    @Then("verify it contains the sku using in search")
    public void verifyItContainsTheSkuUsingInSearch() {
        String actualresult=driver.findElement(By.id("sku-4")).getText();
        Assert.assertEquals(actualresult, "AP_MBP_13");
    }

}
