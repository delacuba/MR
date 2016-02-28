import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {

        WebDriver driver;
        LoginPage objLogin;
        HomePage objHome;

    @BeforeTest
        public void setup(){
            driver = new FirefoxDriver();
            driver.get("https://mail.ru/");
        }

    @Test
    public void test_Home_Page_Appear_Correct(){
        //Create Login Page object
        objLogin = new LoginPage(driver);
        //login to application
        objLogin.setUserName("testerov2003");
        objLogin.setPassword("Hot_hot_hot_123");
        objLogin.selectMailDomain("mail.ru");
        objLogin.clickAuthButton();

        // go the next page
        objHome = new HomePage(driver);
        //Verify home page
        Assert.assertTrue(objHome.isLogoutButtonDisplayed());
    }
}
