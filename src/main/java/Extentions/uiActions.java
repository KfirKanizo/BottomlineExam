package Extentions;

import Utilities.commonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class uiActions extends commonOps
{
    public static void click(WebElement clickOn)
    {
        clickOn.click();
    }

    public static void getText(WebElement getTextFrom)
    {
        wait.until(ExpectedConditions.visibilityOf(getTextFrom));
        getTextFrom.getText();
    }

    public static void updateText(WebElement sendTextTo, String whatTheText)
    {
        wait.until(ExpectedConditions.visibilityOf(sendTextTo));
        sendTextTo.sendKeys(whatTheText);
    }
}
