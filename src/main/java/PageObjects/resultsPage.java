package PageObjects;

import Utilities.commonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resultsPage
{
    @FindBy(xpath = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]")
    public WebElement txt_resultsAmount;

    @FindBy(css = "#n\\/283155 > span > a > span")
    public WebElement btn_booksFilter;

    @FindBy(css = "#p_n_feature_nine_browse-bin\\/3291437011 > span > a > div > label > i")
    public WebElement cb_englishFilter;

    @FindBy(xpath = "//*[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement txt_resultsName;

    @FindBy(xpath = "//li[@class='a-last']/a")
    public WebElement btn_next;


}
