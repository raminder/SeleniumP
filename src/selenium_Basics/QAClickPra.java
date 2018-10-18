package selenium_Basics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class QAClickPra {
    
    WebDriver driver;

    @BeforeTest
   public void openBrowser(){
       System.setProperty("webdriver.chrome.driver", "D:/AutomationProject/chromedriver_win32/chromedriver.exe");  
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://www.qaclickacademy.com/practice.php");
       }
   
    
    @Test(enabled=false)
    public void clickRadioButton() {
        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[class=radioButton]"));
        for(int i=0;i<radioButtons.size();i++){
            String text=radioButtons.get(i).getAttribute("value");
            if(text=="Radio 2"){
                radioButtons.get(i).click();
                Assert.assertTrue(radioButtons.get(i).isSelected());
                }
            }
        
      }
    
    @Test(enabled=false)
    public void selectCheckbox(){
        WebElement Checkbox=driver.findElement(By.id("checkBoxOption3"));
        Assert.assertFalse(Checkbox.isSelected());
        Checkbox.click();
        String text=Checkbox.getAttribute("value");
        Assert.assertTrue(Checkbox.isSelected());
        System.out.println(text);
    }
    
    @Test(enabled=false)
    public void switchWindow(){
        WebElement win=driver.findElement(By.id("openwindow"));
        win.click();
        System.out.println(win.getText());
        Set<String> openWindow=driver.getWindowHandles();
        //driver.switchTo().window(openWindow.);
        System.out.println(openWindow.size());
        Iterator<String> it=openWindow.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
        System.out.println(win.getText());
    }
    
    @Test(enabled=false)
    public void switchTab(){
        WebElement tab=driver.findElement(By.id("opentab"));
        tab.click();
        Set<String> openWindows=driver.getWindowHandles();
        System.out.println(openWindows.size());
        Iterator<String> it=openWindows.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
    }

    @Test(enabled=false)
    public void alertAccept(){
        driver.findElement(By.id("name")).sendKeys("Raman");
        driver.findElement(By.id("alertbtn")).click();
       Alert alertPopUp= driver.switchTo().alert();
       System.out.println(alertPopUp.getText());
       alertPopUp.accept();
       driver.findElement(By.id("confirmbtn")).click();
       Alert newAlrt=driver.switchTo().alert();
       System.out.println(newAlrt.getText());
       newAlrt.accept();
        }
    
    @Test(enabled=false)
    public void cancelAccept(){
        driver.findElement(By.id("name")).sendKeys("Raman");
       driver.findElement(By.id("confirmbtn")).click();
       Alert newAlrt=driver.switchTo().alert();
       System.out.println(newAlrt.getText());
       newAlrt.dismiss();
        }
 
    @Test(enabled=false)
    public void selectDropdown(){
        Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
        dropdown.selectByIndex(1);
        dropdown.selectByValue("option3");
        dropdown.selectByVisibleText("Option1");
        Assert.assertFalse(dropdown.isMultiple());
    }
    
    @Test(enabled=false)
    public void autoSuggest(){
        driver.findElement(By.id("autocomplete")).click();
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        String text=(String) js.executeScript("return document.getElementById(\"autocomplete\").value;");
        System.out.println(text);
       
    }   
    
    @Test(enabled=false)
    public void hideShow(){
        WebElement web=driver.findElement(By.id("displayed-text"));
        Assert.assertTrue(web.isDisplayed());
        driver.findElement(By.id("hide-textbox")).click();
        Assert.assertFalse(web.isDisplayed());
        driver.findElement(By.id("show-textbox")).click();
        Assert.assertTrue(web.isDisplayed());
    }
    @Test(enabled=false)
    public void mouseIntercations(){
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
        driver.findElement(By.linkText("Reload")).click();
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mousehover"))));
    }
    
    @Test(enabled=false)
    public void switchFrameE(){
        driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
        driver.findElement(By.partialLinkText("Courses")).click();
        List<WebElement> courses=driver.findElements(By.className("img-responsive"));
        courses.get(1).click();
       Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn-primary.take-course")).isDisplayed());
       System.out.println(driver.findElement(By.cssSelector(".text-center")).getText());
       driver.switchTo().defaultContent();
       System.out.println(driver.findElement(By.className("text-center")).getText());
    }
    
    @Test
    public void getTableData(){
        WebElement table=driver.findElement(By.id("product"));
        int rows=table.findElements(By.xpath("//*[@id='product']/tbody/tr")).size();
        System.out.println(rows);
        int count=table.findElements(By.xpath("//*[@id='product']/tbody/tr/td[3]")).size();
        System.out.println(count);
        for(int i=0;i<count;i++){
            System.out.println(table.findElements(By.xpath("//*[@id='product']/tbody/tr/td[3]")).get(i).getText());
           
        }
    }
@AfterTest
public void closeBrowser(){
    driver.quit();
 }
}