package selenium_Basics;

import static org.testng.Assert.assertEquals;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration {
    @Test

    public void applicationTitle() {
        System.setProperty("webdriver.chrome.driver", "D:/MNSProject/chromedriver_win32 _v2.28/chromedriver_win32 _v2.28/chromedriver.exe");  
        
        WebDriver driver=new ChromeDriver();
        driver.get("http://demoqa.com/");
        driver.getTitle().contains("Demoqa");
        driver.findElement(By.id("menu-registration")).click();
        driver.getTitle().contains("Registartion");
        driver.findElement(By.id("name_3_firstname")).sendKeys("test");
        driver.findElement(By.id("name_3_lastname")).sendKeys("kr");
        List <WebElement> martialStatus= driver.findElements(By.cssSelector("input[name='radio_4[]']"));
        martialStatus.get(0).click();
        List <WebElement> hobby= driver.findElements(By.cssSelector("input[name='checkbox_5[]']"));
        hobby.get(0).click();
        Select country = new Select(driver.findElement(By.id("dropdown_7")));
        country.selectByValue("India");
        Select mnth = new Select(driver.findElement(By.id("mm_date_8")));
        mnth.selectByIndex(7);
        Select day = new Select(driver.findElement(By.id("dd_date_8")));
        day.selectByIndex(2);
        Select year = new Select(driver.findElement(By.id("yy_date_8")));
        year.selectByValue("2012");
        driver.findElement(By.id("phone_9")).sendKeys("01234567890");
        long time = System.currentTimeMillis();
        driver.findElement(By.id("username")).sendKeys("test" + time);
        driver.findElement(By.id("email_1")).sendKeys("test" + time +"@gmail.com");
        driver.findElement(By.id("password_2")).sendKeys("testing@123");
        driver.findElement(By.id("confirm_password_password_2")).sendKeys("testing@123");
        driver.findElement(By.cssSelector("input[name=pie_submit]")).click();
       WebElement successMsg =driver.findElement(By.cssSelector(".entry-content .piereg_message"));
       Assert.assertTrue(successMsg.isDisplayed(), "Registration is not sucessful");
        driver.quit();
    }
}
            
                      