package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;

/**
 * Created by Артем on 28.03.2017.
 */
public class MainPageOnliner extends BaseForm {

    public MainPageOnliner() {
        super(By.xpath("//div[@class='g-middle']"), "Onliner main page");
    }

}