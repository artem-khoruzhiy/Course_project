package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

/**
 * Created by Артем on 31.03.2017.
 */
public class CartPage extends BaseForm {
    private Label lblNameFirstProduct = new Label(By.xpath("//div[@class='cart-product-title']//span"), "First product");
    private Button btnDeleteFromCart = new Button(By.xpath("//a[@title='Удалить']"), "Delete button");

    public CartPage(){
        super(By.xpath("//h1[text()='Корзина']"), "Cart page");
    }

    public String getNameOfFirstProduct(){
        return lblNameFirstProduct.getText();
    }

    public void deleteFromCart(){
        btnDeleteFromCart.click();
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){

        }
    }
}