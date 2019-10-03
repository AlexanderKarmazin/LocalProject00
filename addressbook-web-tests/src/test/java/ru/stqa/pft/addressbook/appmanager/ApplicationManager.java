package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.fail;

public class ApplicationManager {
    private  ChromeDriver driver;
    private GroupHelper groupHelper;
    private SessionHelper SessionHelper;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();



    public void init() {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver_win32\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper((ChromeDriver) driver);
        SessionHelper = new SessionHelper(driver) ;
        SessionHelper.login("admin", "secret");
    }



    private void logout() {
      driver.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        logout();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }
}
