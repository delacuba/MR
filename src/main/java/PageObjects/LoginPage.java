package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class LoginPage {
    WebDriver driver;

    //fields and buttons
    By userName = By.id("mailbox__login");
    By password = By.id("mailbox__password");
    By mailDomain = By.id("mailbox__login__domain");
    By authButton = By.id("mailbox__auth__button");
    By logoLogin = By.className("logo__link__img logo__link__img_medium");

    private static final Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        log.info("Sets user name");
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        log.info("Sets password");
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickMailDomain(){
        driver.findElement(mailDomain).click();
    }

    public void selectMailDomain(String strMailDomain){
        Select dropdown = new Select(driver.findElement(mailDomain));
        switch (strMailDomain){
            case "mail.ru":
                clickMailDomain();
                dropdown.selectByValue("mail.ru");
                break;
            case "inbox.ru":
                clickMailDomain();
                dropdown.selectByValue("inbox.ru");
                break;
            case "list.ru":
                clickMailDomain();
                dropdown.selectByValue("list.ru");
                break;
            case"bk.ru":
                clickMailDomain();
                dropdown.selectByValue("bk.ru");
                break;
            case"mail.ua":
                clickMailDomain();
                dropdown.selectByValue("mail.ua");
                break;
            default: new Exception("No such Mail Domain");
        }
    }

    public void clickAuthButton(){
        driver.findElement(authButton).click();
    }

    public void isLogiPageDisplayed(){
        driver.findElement(logoLogin).isDisplayed();
    }
}
