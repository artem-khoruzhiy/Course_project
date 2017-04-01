package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Артем on 28.03.2017.
 */
public class BookmarksPage extends BaseForm {

    private String locForPointOfMenu = "//div[@class='b-hdtopic']//a[text()='%s']";

    public BookmarksPage(){
        super(By.xpath("//div[@class='b-hdtopic']"), "Bookmarks page");
    }

    public void navigateOnBookmarksMenu(String section){
        Button btnSection = new Button(By.xpath(String.format(locForPointOfMenu, section)), section + " button");
        btnSection.click();
    }
}