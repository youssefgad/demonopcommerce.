package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.example.pages.P04_WishList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;
import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    P04_WishList Wishlist = new P04_WishList();
    @When("user click on wishlist button ❤️ on this product \"HTC One M8 Android L 5.0 Lollipop\"")
    public void UserClickOnWishlistButton() throws InterruptedException {
        homePage.HTCWishlisticon.click();
    }

    @Then("user see success message")
    public void userSeeSuccessMessage()  throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        String expectedResult = "The product has been added to your wishlist";
        String actualResult = homePage.successmessage.getText();
        soft.assertEquals(actualResult.contains(expectedResult),true);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        // color
        String expectedColor = "rgba(75, 176, 122, 1)";
        String actualColor = homePage.disablecolor.getCssValue("background-color");
        System.out.println(actualColor);
        soft.assertTrue(actualColor.contains(expectedColor));
        soft.assertAll();
    }

    @When("user click on wishlist button HTC")
    public void userClickOnWishlistButtonHTC()  throws InterruptedException {
        homePage.HTCWishlisticon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(4000);
    }

    @And("user click on Wishlist Tab")
    public void userClickOnWishlistTab() {
        homePage.WishlistLink.click();

    }

    @Then("Verify user product add in wishlist-page")
    public void verifyUserProductAddInWishlistpage() {

        String actualqtr = Wishlist.WishlistPage.getAttribute("value");
        int Actualint= Integer.parseInt(actualqtr);
        System.out.println(actualqtr);

        int expectedqtr = 1;
        Assert.assertEquals(Actualint, expectedqtr);



    }
}
