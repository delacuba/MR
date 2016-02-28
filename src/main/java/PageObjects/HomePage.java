package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver =driver;
    }

    By logoutButton = By.id("PH_logoutLink");

    public boolean isLogoutButtonDisplayed(){
       return driver.findElement(logoutButton).isDisplayed();
    }
}
