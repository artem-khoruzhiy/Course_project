package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Артем on 31.03.2017.
 */
public class CamerasPage extends BaseForm {
    private Button btnFirstCamera = new Button(By.xpath("//div[@class='schema-product__title']/a/span"), "first camera");

    public CamerasPage(){
        super(By.xpath("//h1[text()='Фотоаппараты']"), "Cameras page");
    }

    public void openFirst(){
        btnFirstCamera.waitForIsElementPresent();
        btnFirstCamera.click();
    }
}
