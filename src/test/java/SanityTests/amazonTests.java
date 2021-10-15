package SanityTests;

import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static WorkFlows.webFlows.getLongestProductNameInAllPages;

public class amazonTests extends commonOps
{
    @Test
    public void TC01_searchForHarryPotterBookAndViewResultsAmount()
    {
        webFlows.searchForProduct("Harry Potter the Order of the Phoenix");
        verifications.verifyText(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]")).getText(), "1-16 of 455 results for");
    }

    @Test
    public void TC02_filterToEnglishBooksOnlyAndViewResultsAmount()
    {
        driver.findElement(By.cssSelector("#n\\/283155 > span > a > span")).click();
        driver.findElement(By.cssSelector("#p_n_feature_nine_browse-bin\\/3291437011 > span > a > div > label > i")).click();
        verifications.verifyText(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]")).getText(), "1-16 of 332 results for");
//        webFlows.filterToEnglishBooks();
    }

    @Test
    public void TC03_printAllBookNamesInPage()
    {
        webFlows.printAllBookNameInPage();
    }

    @Test
    public void TC04_printTheShortestBookNameInPage()
    {
        webFlows.printTheShortestBookNameInPage();
    }


    @Test
    public void TC05_printTheLongestBookNameInPage()
    {
        webFlows.printTheLongestBookNameInPage();
    }


    @Test
    public void TC06_printTheLongestBookInAllPages()
    {
        System.out.println("The book with the LONGEST name in ALL Pages: " + getLongestProductNameInAllPages());
    }

}
