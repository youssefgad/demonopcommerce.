package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class P02_login {
    public P02_login() { PageFactory.initElements(Hooks.driver,this);}

    @FindBy(className ="ico-login")
    public WebElement login;


    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement Password;

    @FindBy(className = "login-button")
    public WebElement loginButton;

    @FindBy(className = "ico-account")
    public WebElement disableMyaccountTab;

    @FindBy(xpath=("//div[@class='message-error validation-summary-errors']"))
    public WebElement Errormessage;
}
