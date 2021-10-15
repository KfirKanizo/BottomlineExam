package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
    amazonHomePage = PageFactory.initElements(driver, PageObjects.homePage.class);
    amazonResultsPage = PageFactory.initElements(driver, PageObjects.resultsPage.class);
    }
}
