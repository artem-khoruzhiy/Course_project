package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Артем on 28.03.2017.
 */
public class ProductsPage extends BaseForm {

    private Button btnFirstProduct = new Button(By.xpath("//div[@id='schema-products']//div[@class='schema-product__title']/a"), "First product");

    public ProductsPage(){
        super(By.xpath("//h1[@class='schema-header__title']"), "Products phones");
    }

    public void openFirstProduct(){
        btnFirstProduct.click();
    }
}