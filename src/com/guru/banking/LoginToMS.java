package com.guru.banking;


    import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.guru.bankingutils.ReusableMethods;
    import com.guru.bankingutils.Util;
    import com.guru.bankingutils.Locators;
    import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.*;
    import com.guru.banking.TestData;
    import com.guru.banking.ReadJson;


    public class LoginToMS {


     
        public static void main(String[] args) 
                throws IOException, InterruptedException {
            System.setProperty("webdriver.chrome.driver", "D:/AutomationProject/chromedriver_win32/chromedriver.exe");  
            WebDriver driver=new ChromeDriver();
            driver.get("https://www.marksandspencer.com/webapp/wcs/stores/servlet/MSResLogin?catalogId=10051&myAcctMain=1&langId=-24&storeId=10151&sourceurl=https%3A%2F%2Fwww.marksandspencer.com%2F");
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            ReadJson rd=new ReadJson();
            TestData obj=rd.getJsonData();
            //driver.findElement(By.xpath("//li[@id='headerSignInLink-fear']/span[1]")).click();
            driver.findElement(By.cssSelector("input[id='loginEmail']")).sendKeys(obj.getUsername());
            driver.findElement(By.cssSelector("input[name='logonPassword']")).sendKeys(obj.getPassword());
            driver.findElement(By.cssSelector(".my-account__subcontent__signIn-btn.btn--active")).click();
            /*WebElement searchBox=driver.findElement(By.cssSelector("#global-search"));
            searchBox.click();
            searchBox.sendKeys("dress");
            searchBox.sendKeys(Keys.ENTER);
            driver.getTitle().contains("Search Results");
            WebDriverWait wait=new WebDriverWait(driver,3);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid-view")));
            //driver.findElement(By.xpath("//*[@class='grid-view']/li[1]")).click();
            Actions ac=new Actions(driver);
            ac.moveToElement(driver.findElement(By.cssSelector(".grid-view li:nth-child(1) div:nth-child(1)"))).build().perform();
            driver.findElement(By.cssSelector(".grid-view li:nth-child(1) div:nth-child(1) a:first-child")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lightboxQuick")));
            WebElement table=driver.findElement(By.className("sizes"));
            List<WebElement> sizes=table.findElements(By.xpath("//tbody/tr[2]/td"));
            for(int i=0;i<sizes.size();i++){
                String sizeValue=sizes.get(i).getAttribute("value");
                if(sizeValue.equals("8Regular")){
                    sizes.get(i).click();    
                }
            }
            driver.findElement(By.cssSelector(".opacty input[class='basket']"));*/
            Actions acn=new Actions(driver);
            acn.moveToElement(driver.findElement(By.cssSelector(".header-link"))).click().build().perform();
            //acn.moveToElement(driver.findElement(By.cssSelector(".res-nav-header__title-text"))).click().build().perform();
            driver.findElement(By.cssSelector(".btn.btn__icon.btn__icon--lock.btn--primary.pull-right")).click();
            WebDriverWait wait1=new WebDriverWait(driver,3);
            wait1.until(ExpectedConditions.titleContains("Express Checkout"));
            //driver.findElement(By.xpath("//*[@class='delivery-toggle-header']")).click();
            //wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#sdd"))));
            driver.findElement(By.linkText("Change")).click();
            //changeLink.click();
            //*[@class='delivery--details__address spc-delivery-info']/div/a
           // driver.findElement(By.cssSelector(".change-addr__add-link"));
            driver.findElement(By.cssSelector(".change-addr__add-edit-links a:nth-child(2)")).click();
            driver.findElement(By.cssSelector(".address-overlay__links a:nth-child(1)")).click();
            driver.findElement(By.cssSelector("#address1")).sendKeys(obj.getAddress().get(1).getAddress1());
            driver.findElement(By.cssSelector("#address2")).sendKeys(obj.getAddress().get(1).getAddress2());
            driver.findElement(By.cssSelector("#address3")).sendKeys(obj.getAddress().get(1).getAddress3());
            driver.findElement(By.cssSelector("#city")).sendKeys(obj.getAddress().get(1).getCity());
            driver.findElement(By.cssSelector("#postcode")).sendKeys(obj.getAddress().get(1).getAddress3());
            driver.findElement(By.cssSelector(".btn.btn--primary.address-overlay__btn--primary")).click();
            driver.quit();
         }

        
    }  



