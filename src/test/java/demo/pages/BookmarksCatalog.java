package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Link;

/**
 * Created by Артем on 28.03.2017.
 */
public class BookmarksCatalog extends BaseForm {
    private Link addedProduct = new Link(By.xpath("//tbody/tr[1]/td[@class='pdescr']/strong/a"), "added product");

    public BookmarksCatalog(){
        super(By.xpath("//ul[@class='gray-btn-segmented']/li[@class='active']/a[text()='Каталог']"), "Bookmarks from catalog");
    }

    public String getNameOfFirstProductFromBookmarks(){
        return addedProduct.getText();
    }
}