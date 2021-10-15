package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("Chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("FireFox"))
            driver = initFFDriver();
        else
            throw new RuntimeException(("Invalid Platform Type Stated."));

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }


    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    @BeforeClass
    public void startSession()
    {
        String platform = "Web";
        if (platform.equalsIgnoreCase("Web"))
            initBrowser("Chrome");
        else
            throw new RuntimeException(("Invalid Platform Type Stated."));

        managePages.init();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterClass
    public void closeSession()
    {
        driver.quit();
    }


}
