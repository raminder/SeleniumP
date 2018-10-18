package com.guru.banking;


    import org.testng.annotations.Test;
    import java.io.IOException;
    import com.guru.bankingutils.ReusableMethods;
    import com.guru.bankingutils.Util;
    import com.guru.bankingutils.Locators;
    import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
    import org.openqa.selenium.NoAlertPresentException;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.annotations.BeforeTest;


    public class LoginToBank {


        private WebDriver driver;
     
        @BeforeTest
        public void openbrowser() {
            System.setProperty(Util.driverName, Util.driverPath);
            driver = new ChromeDriver();
            driver.get(Util.siteUrl);
            driver.manage().window().maximize();
        }

        @Test(dataProvider="getValidData",dataProviderClass=ReusableMethods.class,priority=0)
        public void loginBankSucces(String username,String Password)
                throws IOException {
            driver.findElement(By.cssSelector(Locators.userId)).sendKeys(username);
            driver.findElement(By.cssSelector(Locators.password)).sendKeys(Password);
            driver.findElement(By.xpath(Locators.loginButton)).click();
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,"Guru99 Bank Manager HomePage");
            String managerIdText=driver.findElement(By.tagName(Locators.managerId)).getText();
            String[] parts=managerIdText.split(Util.PATTERN);
            String dynamicText=parts[1];
            Assert.assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));
            String remain=dynamicText.substring(dynamicText.length() - 4);
            System.out.println(remain);
            Assert.assertTrue(remain.matches(Util.SECOND_PATTERN));
            Assert.assertTrue(logOut());
            }

        
    public String loginAlert() {
            Alert handleAlert = driver.switchTo().alert();
            String actualAlertText = handleAlert.getText();
            handleAlert.accept();
            return actualAlertText;
        }

        
        public boolean logOut() {
            driver.findElement(By.cssSelector(Locators.logOutLink)).click();
      {

                if (loginAlert().equals(Util.logoutSuccess)) {
                    System.out.println("Test case: Passed");
                    return true;
                } else
                    System.out.println("Test case: Failed");
                return false;
            } 
            }

        @Test(priority=2)
        public void closebrowser(){
            driver.quit();
        }
        
       @Test(dataProvider="getInvalidData",dataProviderClass=ReusableMethods.class,priority=1)
       public void loginFailure(String username,String password)
                throws IOException {
            driver.findElement(By.cssSelector(Locators.userId)).sendKeys(username);
            driver.findElement(By.cssSelector(Locators.password)).sendKeys(password);
            driver.findElement(By.xpath(Locators.loginButton)).click();
            Assert.assertEquals(loginAlert(),Util.loginError);
            }
       
    }



