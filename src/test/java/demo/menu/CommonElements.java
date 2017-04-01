package demo.menu;

import org.openqa.selenium.By;
import webdriver.elements.Button;
import webdriver.elements.Label;

/**
 * Created by Артем on 31.03.2017.
 */
public class CommonElements {
    private String sectionMainMenuLocator = "//ul[@class='b-main-navigation']//span[text()='%s']";
    private String sectionUserMenuLocator = "//ul[contains(@class, 'user-bar')]//a[text()='%s']";
    private Button btnCart = new Button(By.xpath("//a[contains(@class, 'cart')]/span[contains(text(), 'товар')]"), "Cart");
    private Button btnSignIn = new Button(By.xpath("//div[contains(text(), 'Вход')]"), "Sign In Button");
    private Label lblUserLogin = new Label(By.xpath("//p[@class='user-name']/a"), "user login");

    public void navigateOnMainMenu(String section){
        Button btnSection = new Button(By.xpath(String.format(sectionMainMenuLocator, section)), section + " button");
        btnSection.click();
    }

    public void navigateOnUserMenu(String section){
        Button btnSection = new Button(By.xpath(String.format(sectionUserMenuLocator, section)),
                section + " button");
        btnSection.waitForIsElementPresent();
        btnSection.click();
    }

    public boolean checkSuccessfulLogin(String login){
        lblUserLogin.waitForIsElementPresent();
        if (lblUserLogin.getText().equals(login))
            return true;
        return false;
    }

    public void openCart(){
        btnCart.waitForIsElementPresent();
        btnCart.click();
    }

    public void enterToAccount(){
        btnSignIn.click();
    }
}