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
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user click on facebook link")
    public void UserClickOnFacebookLink() throws InterruptedException {
        homePage.Facebookicon.click();
        Thread.sleep(3000);

    }

    @Then("user verify that facebook page display")
    public void userVerifyThatFacebookPageDisplay() throws InterruptedException {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce");
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }

    @When("user click on twitter link")
    public void userClickOnTwitterLink()throws InterruptedException {
        homePage.Twittericon.click();
        Thread.sleep(3000);


    }

    @Then("user verify that twitter page display")
    public void userVerifyThatTwitterPageDisplay()  throws InterruptedException {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/nopCommerce");
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }

    @When("user click on RSS link")
    public void userClickOnRSSLink() throws InterruptedException {
        homePage.RSSicon.click();
        Thread.sleep(3000);

    }

    @Then("user verify that RSS page display")
    public void userVerifyThatRSSPageDisplay() throws InterruptedException {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open");
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }

    @When("user click on youtube link")
    public void userClickOnYoutubeLink() throws InterruptedException {
        homePage.YouTubeicon.click();
        Thread.sleep(3000);

    }

    @Then("user verify that youtube page display")
    public void userVerifyThatYoutubePageDisplay() throws InterruptedException {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce");
        driver.close();
        driver.switchTo().window(tabs.get(0));


    }
}