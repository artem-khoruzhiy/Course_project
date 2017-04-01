package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

/**
 * Created by Артем on 28.03.2017.
 */
public class ConcreteProductPage extends BaseForm {

    private Button btnAddToBookmarks = new Button(By.xpath("//span[text()='В закладки']"), "Add to bookmarks button");
    private Button btnDeleteFromBookmarks = new Button(By.xpath("//span[text()='В закладках']"), "Delete from bookmarks");
    private Label lblNameOfProduct = new Label(By.tagName("h1"), "Name of product");
    private Button btnShowOffers = new Button(By.xpath("//div[contains(@class, 'offers-description__part')]/a"), "Show offers");

    public ConcreteProductPage(){
        super(By.xpath("//h3[contains(text(), 'Описание')]"), "Concrete product page");
    }

    public void addToBookmarks(){
        if (btnDeleteFromBookmarks.isPresent())
        btnDeleteFromBookmarks.click();
        btnAddToBookmarks.click();
    }

    public String getNameOfProduct(){
        return lblNameOfProduct.getText();
    }

    public void openOffers(){
        btnShowOffers.click();
    }
}