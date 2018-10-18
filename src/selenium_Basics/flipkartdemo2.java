package selenium_Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class flipkartdemo2 {

    @Test
    public void lauchflipkart() throws InterruptedException{
        
        System.setProperty("webdriver.chrome.driver", "D:/AutomationProject/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.cssSelector("._2AkmmA._29YdH8")).click();
        driver.findElement(By.cssSelector(".LM6RPg")).click();
        driver.findElement(By.cssSelector(".LM6RPg")).sendKeys("dress");
       
       driver.findElement(By.cssSelector(".LM6RPg")).sendKeys(Keys.DOWN);
       driver.findElement(By.cssSelector(".LM6RPg")).sendKeys(Keys.DOWN);
       driver.findElement(By.cssSelector(".LM6RPg")).sendKeys(Keys.DOWN);
       
        //driver.findElement(By.cssSelector(".vh79eN")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       }
    }

