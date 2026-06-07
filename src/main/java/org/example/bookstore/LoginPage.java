package org.example.bookstore;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement signInButton;

    @FindBy(css = "#submit")
    private WebElement loginButton;

    @FindBy(id = "submit")
    private WebElement signInButtonId;

    @FindBy(css = "#submit")
    private WebElement signInButtonCss;

    @FindBy(xpath = "//*[@id='flash']")
    private WebElement popUpError;

    @FindBy(xpath = "//*[@id='welcome-message']")
    private WebElement welcomeMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        scrollToElement(inputEmail);
        waitForElementToBeVisible(inputEmail);
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        signInButtonId.click();
    }

    public boolean verifyLoginSuccess() {
        waitForElementToBeVisible(welcomeMessage);
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyLoginFailed() {
        waitForElementToBeVisible(popUpError);
        return popUpError.isDisplayed();
    }

    public String getFlashMessageText() {
        waitForElementToBeVisible(popUpError);
        String text = popUpError.getText().trim();

        return text.replace("×", "").trim();
    }
}
