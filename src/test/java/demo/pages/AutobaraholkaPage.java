package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.ComboBox;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 29.03.2017.
 */
public class AutobaraholkaPage extends BaseForm {

    private ComboBox model = new ComboBox(By.xpath("//select[@class='manufacture']"), "Model selection");
    private Button btnSortByPrice = new Button(By.xpath("//ul[@class='autoba-sorters']//a[text()='Цена, р.']"), "Sort by price");
    private String locForPriceBYN = "//span[@class='price-primary']";

    public AutobaraholkaPage(){
        super(By.xpath("//h1[text()='Автобарахолка']"), "Autobaraholka page");
    }

    public void selectModel(String name){
        model.selectByText(name);
    }

    public void sortByPrice(){
        btnSortByPrice.waitForIsElementPresent();
        btnSortByPrice.click();
    }

    public List<Double> getListOfPrices(){
        try {
            Thread.sleep(400);
        }catch (InterruptedException e){}
        List<WebElement> listOfPricesElements = browser.getDriver().findElements(By.xpath(locForPriceBYN));
        List<Double> prices = new ArrayList<>();
        for(WebElement el : listOfPricesElements){
            Double price = Double.parseDouble(el.getText().replace(",", ".").replaceAll("\\s", ""));
            prices.add(price);
        }
        return prices;
    }

    public boolean checkOrder(){
        List<Double> list = getListOfPrices();
        boolean condition = false;
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i).compareTo(list.get(i + 1)) <= 0)
                condition = true;
            else
                return false;
        }
        return condition;
    }
}
