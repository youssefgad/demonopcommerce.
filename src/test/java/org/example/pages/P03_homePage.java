package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.example.stepDefs.D05_hoverCategoriesStepDef;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import java.util.List;


public class P03_homePage {
    public P03_homePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(id = "customerCurrency")
    public WebElement currencyList;


    @FindBy(xpath = ("//*[@id=\"customerCurrency\"]/option[2]"))
    public WebElement EURO;

    // search

    @FindBy(id = "small-searchterms")
    public WebElement search;


    @FindBy(xpath = ("//a[normalize-space()='Apple MacBook Pro 13-inch']"))
    public WebElement productTitle;

    @FindBy(css = "a[href=\"/computers\"]")
    public WebElement MainCategory;

    @FindBy(xpath = "(//a[@href='http://demo.nopcommerce.com/'])[1]")
    public WebElement NokiaSlider;

    @FindBy(xpath = "(//a[@href='http://demo.nopcommerce.com/'])[2]")
    public WebElement IphoneSlider;

    @FindBy(xpath = "//a[normalize-space()='Facebook']")
    public WebElement Facebookicon;

    @FindBy(xpath = "//a[normalize-space()='Twitter']")
    public WebElement Twittericon;

    @FindBy(xpath = "//a[normalize-space()='RSS']")
    public WebElement RSSicon;


    @FindBy(xpath = "//a[normalize-space()='YouTube']")
    public WebElement YouTubeicon;

    @FindBy(xpath="(//button[@title='Add to wishlist'][normalize-space()='Add to wishlist'])[3]")
    public WebElement HTCWishlisticon;

    @FindBy(className = ("wishlist-label"))
    public WebElement WishlistLink ;

    @FindBy(xpath = ("//*[@id=\"bar-notification\"]/div"))
    public WebElement disablecolor;

    @FindBy(xpath = ("//div[@class='bar-notification-container'][contains(.,'The product has been added to your wishlist')]"))
    public WebElement successmessage;

    public WebElement subTitle(){
        return Hooks.driver.findElement(By.className("page-title"));
    }
    public List<WebElement> categorieList(){
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
    public List<WebElement> subList(int selectedCategories){
        return Hooks.driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']//ul)["+(selectedCategories+1)+"]/li"));
    }
}
