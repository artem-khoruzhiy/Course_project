package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.Link;
import webdriver.elements.TextBox;
import static org.testng.Assert.*;

/**
 * Created by Артем on 28.03.2017.
 */
public class MessagesPage extends BaseForm {
    private TextBox txtAddressee = new TextBox(By.id("compose_uname"), "Addressee field");
    private TextBox txtHeading = new TextBox(By.id("compose_subject"), "Theme of message field");
    private TextBox txtMessage = new TextBox(By.xpath("//textarea[@id='compose_text']"), "Text of Messagefield");
    private Button btnSubmit = new Button(By.xpath("//button[@value='Отправить']"), "Submit message button");
    private String locForMessByTheme = "//a[text()='%s']";
    private String locForLocalMenu = "//ul[@class='b-vnav']//a[text()='%s']";
    private Label lblHeading = new Label(By.xpath("//h2[@class='pmmsg__subj']"), "Theme of received message");
    private Label lblSender = new Label(By.xpath("//big[@class='mtauthor-nickname']/a"), "Sender");
    private Label lblText = new Label(By.xpath("//div[@class='msgpost-txt-i']/p"), "Text of message");

    public MessagesPage(){
        super(By.xpath("//h1[text()='Личные сообщения']"), "Messages Page");
    }

    public void navigateOnMessageMenu(String name){
        new Button(By.xpath(String.format(locForLocalMenu, name)),  name + " button").click();
    }

    public void enterAddressee(String adrressee){
        txtAddressee.setText(adrressee);
    }

    public void enterHeading(String heading){
        txtHeading.setText(heading);
    }

    public void enterMessage(String message){
        txtMessage.setText(message);
    }

    public void submitMessage(){
        btnSubmit.click();
    }

    public void openMessageByTheme(String theme){
        new Link(By.xpath(String.format(locForMessByTheme, theme)), "Link of message").click();
    }

    public void assertTrueMessage(String expSender, String expHeading,  String expTextMsg){
        assertTrue(expSender.equals(lblSender.getText())
                && expHeading.equals(lblHeading.getText())
                && expTextMsg.equals(lblText.getText()));
    }
}