package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

/**
 * Created by Артем on 29.03.2017.
 */
public class SignInPage extends BaseForm{

    private TextBox txtLoginField = new TextBox(By.xpath("//div[contains(@class,'is-active')]//input[@type='text']"), "Login field");
    private TextBox txtPasswordField = new TextBox(By.xpath("//div[contains(@class,'is-active')]//input[@type='password']"), "Password Field");
    private Button btnEnterButton = new Button(By.xpath("//button[contains(text(), 'Войти')]"), "Enter button");

    public SignInPage(){
        super(By.xpath("//div[@class='auth-box__field']"), "Sign in page");
    }

    public void signIn(String login, String password){
        txtLoginField.setText(login);
        txtPasswordField.setText(password);
        btnEnterButton.click();
    }
}