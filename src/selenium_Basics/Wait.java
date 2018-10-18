package selenium_Basics;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wait {
    @Test

    public void applicationTitle() {
        System.setProperty("webdriver.chrome.driver", "D:/MNSProject/chromedriver_win32 _v2.28/chromedriver_win32 _v2.28/chromedriver.exe");  
        
        WebDriver driver=new ChromeDriver();
        
        DesiredCapabilities c=DesiredCapabilities.chrome();
        ChromeOptions ch=new ChromeOptions();
        
        c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver.get("http://http://demoqa.com/");
            String actualTitle = driver.getTitle();
            System.out.println("Title is " +actualTitle);
            //String expectedTitle ="Welcome to Marks & Spencer";
            //Assert.assertEquals(actualTitle, expectedTitle);
            //System.out.println("Completed");
            Assert.assertTrue(actualTitle.contains("Marks"));
            WebElement registrationlink=driver.findElement(By.cssSelector(".reg-linkkkkk"));
            driver.manage().timeouts().implicitlyWait(40,TimeUnit.MILLISECONDS);
            registrationlink.click();
            String newTitle =driver.getTitle();
            Assert.assertEquals(newTitle, "Register", "Registartion page open");
            /*WebElement titleDropdown =driver.findElement(By.id("registerTitle"));
            Select dropdown=new Select(titleDropdown);
            dropdown.selectByValue("Ms");*/
            WebElement drop=driver.findElement(By.id("registerTitle"));
            Select dropdown=new Select(drop);
            List<WebElement> drop1=dropdown.getOptions();
            for(int i=0; i<drop1.size();i++) {
              String value=drop1.get(i).getText();
              System.out.println("Value are" + value);
            }
            
            driver.switchTo().alert().accept();
              WebDriverWait wait = new WebDriverWait(driver, 20);
              
              
              
              
              
    }
}
            
                      