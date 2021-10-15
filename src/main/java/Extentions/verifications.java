package Extentions;

import Utilities.commonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class verifications extends commonOps
{
    public static void textInElement(WebElement elem, String expectedText)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedText);
    }

    public static void numberOfElements(List<WebElement> elems, int expectedValue)
    {
        assertEquals(elems.size(), expectedValue);
    }

    public static void verifyText(String actual, String expected)
    {
        assertEquals(actual, expected);
    }
}
