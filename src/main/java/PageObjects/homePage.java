package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage
{
    @FindBy(id = "twotabsearchtextbox")
    public WebElement input_search;

    @FindBy(id = "nav-search-submit-button")
    public WebElement btn_search;

}
