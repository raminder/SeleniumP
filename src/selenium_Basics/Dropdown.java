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

public class Dropdown {
    @Test

    public void applicationTitle() {
        System.setProperty("webdriver.chrome.driver", "D:/AutomationProject/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.spicejet.com/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //driver.findElement(By.xpath("//a[@value='DIB']")).click();
        driver.findElement(By.xpath("(//a[@value='DIB'])[1]")).click();
        driver.findElement(By.xpath("(//a[@value='GAU'])[2]")).click();
        driver.quit();
        
    }
}
            
                      