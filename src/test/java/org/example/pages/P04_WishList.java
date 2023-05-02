package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class P04_WishList {
    public P04_WishList() { PageFactory.initElements(Hooks.driver,this);}


    @FindBy(css = "input[value='1']")
    public WebElement WishlistPage;
}
