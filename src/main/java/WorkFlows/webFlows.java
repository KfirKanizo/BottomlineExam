package WorkFlows;

import Extentions.uiActions;
import Utilities.commonOps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class webFlows extends commonOps
{

    public static void searchForProduct(String whatYouWantSearchFor)
    {
        uiActions.updateText(amazonHomePage.input_search, whatYouWantSearchFor);
        uiActions.click(amazonHomePage.btn_search);
    }

    public static void filterToEnglishBooks()
    {
        uiActions.click(amazonResultsPage.btn_booksFilter);
        uiActions.click(amazonResultsPage.cb_englishFilter);
    }

    public static void printAllBookNameInPage()
    {
        List<WebElement> bookName =
                driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        for (int i = 0; i < bookName.size(); i++)
        {
            String bookNameString = bookName.get(i).getText();
            System.out.println(bookNameString);
        }
        List<String> allElementsText = new ArrayList<String>();
        for (int x = 0; x < bookName.size(); x++)
        {
            allElementsText.add(bookName.get(x).getText());
        }
        Object obj = Collections.max(allElementsText);

        String longestString = allElementsText.get(0);
        for (String element : allElementsText)
        {
            if (element.length() > longestString.length())
            {
                longestString = element;
            }
        }
    }


    public static void printTheShortestBookNameInPage()
    {
        List<WebElement> bookName =
                driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        for (int i = 0; i < bookName.size(); i++)
        {
            String bookNameString = bookName.get(i).getText();
        }
        List<String> allElementsText = new ArrayList<String>();
        for (int x = 0; x < bookName.size(); x++)
        {
            allElementsText.add(bookName.get(x).getText());
        }
        Object obj = Collections.max(allElementsText);
        System.out.println("The book with the SHORTEST name in the page is: " + obj);
    }


    public static void printTheLongestBookNameInPage()
    {
        List<WebElement> bookName =
                driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        for (int i = 0; i < bookName.size(); i++)
        {
            String bookNameString = bookName.get(i).getText();
        }
        List<String> allElementsText = new ArrayList<String>();
        for (int x = 0; x < bookName.size(); x++)
        {
            allElementsText.add(bookName.get(x).getText());
        }
        Object obj = Collections.max(allElementsText);

        String longestString = allElementsText.get(0);
        for (String element : allElementsText)
        {
            if (element.length() > longestString.length())
            {
                longestString = element;
            }
        }
        System.out.println("The book with the LONGEST name in the page is: " + longestString);
    }


    public static String getLongestProductNameInPage()
    {
        int maximum = 0;
        int currentLength = 0;
        String productName = "";
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement product : products)
        {
            currentLength = product.getText().split("").length;
            if (currentLength > maximum)
            {
                maximum = currentLength;
                productName = product.getText();
            }
        }
        return productName;
    }

    public static String getLongestProductNameInAllPages()
    {
        int maximum = 0;
        String productName = "";
        int currentLength = 0;
        int numberOfPages = Integer.parseInt(driver.findElement(By.xpath("//ul[@class='a-pagination']/li[6]")).getText());
        for (int i = 0; i < numberOfPages; i++)
        {
            currentLength = getLongestProductNameInPage().split("").length;
            if (currentLength > maximum)
            {
                maximum = currentLength;
                productName = getLongestProductNameInPage();
            }
            try
            {
                uiActions.click(amazonResultsPage.btn_next);
            } catch (Exception e)
            {
                System.out.println();
            }

        }
        return productName;
    }
}

