package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Created by Артем on 28.03.2017.
 */
public class Link extends BaseElement {
    public Link(final By locator, final String name) {
        super(locator, name);
    }

    public Link(String string, String name) {
        super(string, name);
    }

    public Link(By locator) {
        super(locator);
    }

    protected String getElementType() {
        return getLoc("loc.link");
    }
}