package guru99bank;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import guru99bank.Util1;
import guru99bank.Locators1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExcelUtils;

public class LoginToBank {

    private String username;
    private String password;

    public static void main(
            String[] args)
            throws Exception {
        System.setProperty(Util1.driverName, Util1.driverPath);
        WebDriver driver = new ChromeDriver();
        LoginToBank lb = new LoginToBank();
        ExcelUtils data = new ExcelUtils();
        lb.openbrowser(driver);
        lb.loginBankSucces(driver, data);
        lb.logOut(driver);
        lb.loginFailure(driver, data);
        driver.quit();
    }

    void openbrowser(
            WebDriver driver) {
        driver.get(Util1.siteUrl);
        driver.manage().window().maximize();
    }

    
    boolean loginBankSucces(
            WebDriver driver, ExcelUtils data)
            throws IOException {
        ArrayList<String> datalogin = data.getLoginData("Enter Valid userid and  password");
        username = datalogin.get(2);
        password = datalogin.get(3);
        driver.findElement(By.cssSelector(Locators1.userId)).sendKeys(username);
        driver.findElement(By.cssSelector(Locators1.password)).sendKeys(password);
        driver.findElement(By.xpath(Locators1.loginButton)).click();
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Guru99 Bank Manager HomePage")) {
            System.out.println("Test case: Passed");
            return true;
        } else
            System.out.println("Test case: Failed");
        return false;
    }

    boolean loginFailure(
            WebDriver driver, ExcelUtils data)
            throws IOException {
        ArrayList<String> datalogin1 = data.getLoginData("Enter invalid userid and valid password");
        username = datalogin1.get(2);
        password = datalogin1.get(3);
        driver.findElement(By.cssSelector(Locators1.userId)).sendKeys(username);
        driver.findElement(By.cssSelector(Locators1.password)).sendKeys(password);
        driver.findElement(By.xpath(Locators1.loginButton)).click();
        if (loginAlert(driver).equals(Util1.loginError)) {
            System.out.println("Test case: Passed");
        } else
            System.out.println("Test case: Failed");
        return false;
    }

    String loginAlert(
            WebDriver driver) {
        Alert handleAlert = driver.switchTo().alert();
        String actualAlertText = handleAlert.getText();
        handleAlert.accept();
        return actualAlertText;
    }

    boolean logOut(
            WebDriver driver) {
        driver.findElement(By.cssSelector(Locators1.logOutLink)).click();
        try {

            if (loginAlert(driver).equals(Util1.logoutSuccess)) {
                System.out.println("Test case: Passed");
                return true;
            } else
                System.out.println("Test case: Failed");
            return false;
        } 
        catch (NoAlertPresentException Ex) {
            System.out.println("Exception occur");
            return false;
        }

    }

}