package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Created by Артем on 30.03.2017.
 */
public class CheckBox extends BaseElement {
    private boolean status = false;

    public CheckBox(final By locator, final String name) {
        super(locator, name);
    }

    public CheckBox(String string, String name) {
        super(string, name);
    }


    public CheckBox(By locator) {
        super(locator);
    }

    protected String getElementType() {
        return getLoc("loc.checkBox");
    }

    public void set(){
        if (status == false){
            this.click();
            status = true;
        }
    }

    public void remove(){
        if (status == true){
            this.click();
            status = false;
        }
    }
}
