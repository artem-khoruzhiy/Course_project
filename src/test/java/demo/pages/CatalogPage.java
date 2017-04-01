package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Артем on 28.03.2017.
 */
public class CatalogPage extends BaseForm {

    private String locForMenu = "//ul[@class='catalog-bar__list']//a[text()='%s']";

    public CatalogPage(){
        super(By.xpath("//h1[text()='Каталог']"), "Catalog page");
    }

    public void navigateOnCatalogMenu(String section){
        Button btnOfTypeProd = new Button(By.xpath(String.format(locForMenu, section)), section + " button");
        btnOfTypeProd.click();
    }
}