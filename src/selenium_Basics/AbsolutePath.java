package selenium_Basics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbsolutePath {

public static void main(String[] args) throws InterruptedException {

                  System.setProperty("webdriver.chrome.driver","D:/MNSProject/chromedriver_win32/chromedriver.exe");
                  WebDriver driver =new ChromeDriver();
                  driver.get("http://www.qaclickacademy.com/interview.php");
                  WebDriverWait w=new WebDriverWait(driver, 20);
                  Actions a=new Actions(driver);
                  driver.findElements(By.tagName("iframes")).size();
                  WebElement ffdriver=driver.findElement(By.xpath("//test"));
                  driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();
                  driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();
                  System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
   
}
}
