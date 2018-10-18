package selenium_Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flipkartdemo {

    @Test
    public void lauchflipkart() throws InterruptedException{
        
        System.setProperty("webdriver.chrome.driver", "D:/MNSProject/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.cssSelector("._2AkmmA._29YdH8")).click();
        driver.findElement(By.cssSelector(".LM6RPg")).click();
        driver.findElement(By.cssSelector(".LM6RPg")).sendKeys("Red Skirt");
        driver.findElement(By.cssSelector(".vh79eN")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int size = 0;
       List<WebElement> abc= driver.findElements(By.cssSelector("._2Xp0TH"));
       for(int i=0;i<=abc.size();i++){
        {
                List<WebElement> totalproducts=driver.findElements(By.cssSelector("._3BTv9X"));
                size=size+totalproducts.size();
                System.out.println(size);
                abc.get(i).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
       }
    }}

