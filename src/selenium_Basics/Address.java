package selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Address {

    public void addAddress(){
        WebDriver driver =new ChromeDriver();
        driver.get("www.sit2.marksandspencer.com");
        driver.findElement(By.className("gmail-nav__nav-link gmail-nav__nav-link__create-account")).click();
        driver.findElement(By.id("firstName")).sendKeys("test");
        driver.findElement(By.id("lastName")).sendKeys("krr");
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.cssSelector(".Xb9hP [name=Passwd]")).sendKeys("testing@123");
        driver.findElement(By.cssSelector(".Xb9hP [name=ConfirmPasswd]")).sendKeys("testing@123");
        driver.findElement(By.className("CwaK9")).click();
    }
}
