package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public  class P01_register {
    public P01_register()

    {
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(className = "ico-register")
    public WebElement register;


    @FindBy(id = "gender-male")
    public WebElement selectGenderMale;

    @FindBy(id = "gender-female")
    public WebElement selectGenderFemale;


    @FindBy(id = "FirstName")
    public WebElement enterFirstName;

    @FindBy(id = "LastName")
    public  WebElement enterLastName;


    @FindBy(name = "DateOfBirthDay")
    public WebElement selectDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement selectMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement selectYear;


    @FindBy(name = "Email")
    public WebElement enterEmail;


    @FindBy(id = "Password")
    public WebElement enterPassword;

    @FindBy(id = "ConfirmPassword")
    public WebElement ConfirmPassword;

    @FindBy(id = "register-button")
    public WebElement clickRegisterButton;

    @FindBy(className = "result")
    public WebElement displaySuccessMessage;

}