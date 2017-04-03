package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Артем on 31.03.2017.
 */
public class OffersPage extends BaseForm {
    private Button toCart = new Button(By.xpath("//a[text()='В корзину']"), "Add to cart");

    public OffersPage(){
        super(By.xpath("//h1[contains(text(), 'Цены')]"), "Offers page");
    }

    public void addToCart(){
        toCart.waitForIsElementPresent();
        toCart.click();
    }
}
