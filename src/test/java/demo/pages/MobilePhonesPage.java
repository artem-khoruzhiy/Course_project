package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.Browser;
import webdriver.elements.CheckBox;
import java.util.List;
import static org.testng.Assert.*;

/**
 * Created by Артем on 30.03.2017.
 */
public class MobilePhonesPage extends BaseForm {
    private String filtersLocator = "//div[@id='schema-filter']/div/div[contains(@class, 'schema-filter__fieldset')]";
    private String producerLocator = "//ul[@class='schema-filter__list']//span[text()='%s']";
    private String allNameOfPhonesLocator = "//div[@class='schema-product__title']//span";

    public MobilePhonesPage(){
        super(By.xpath("//h1[text()='Мобильные телефоны']"), "Mobile phones page");
    }

    public void checkCountOfFilters(){
        List<WebElement> list = browser.getDriver().findElements(By.xpath(filtersLocator));
        assertTrue(list.size() > 0);
    }

    public void setProducer(String name){
        CheckBox checkBox = new CheckBox(By.xpath(String.format(producerLocator, name)), "producer checkbox");
        checkBox.set();
    }

    public void assertTrueProducers(String name){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
        }
        List<WebElement> listOfProducts = Browser.getInstance().getDriver().findElements(By.xpath(allNameOfPhonesLocator));
        for (WebElement el : listOfProducts){
            assertTrue(el.getText().contains(name));
        }
    }
}