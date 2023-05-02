package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;
public class D05_hoverCategoriesStepDef {
    public String SubCategoriesText;
    public int Categories;
    P03_homePage homePage = new P03_homePage();
    @Given("user hover on random category")
    public void userHoverOnRandomCategory() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(Hooks.driver);
        int count = homePage.categorieList().size();
        int min = 0 , max = count-5;
        Categories = (int) Math.floor(Math.random() * (max - min + 1) + min);
        action.moveToElement(homePage.categorieList().get(Categories)).perform();
    }
    @And("user select random subcategory")
    public void userSelectRandomSubcategory(){
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int count = homePage.subList(Categories).size();
        int min = 0 , max = count-1;
        int selectedSubCategories = (int) Math.floor(Math.random() * (max - min + 1) + min);
        SubCategoriesText = homePage.subList(selectedSubCategories).get(selectedSubCategories).getText();
        homePage.subList(Categories).get(selectedSubCategories).click();
    }
    @Then("assert the page title is same like subcategory or category")
    public void assertThePageTitleIsSameLikeSubcategoryOrCategory() {
        Assert.assertTrue(homePage.subTitle().getText().contains(SubCategoriesText));
    }
}
