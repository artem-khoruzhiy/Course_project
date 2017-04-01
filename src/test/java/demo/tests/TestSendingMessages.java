package demo.tests;

import demo.menu.CommonElements;
import demo.pages.MainPageOnliner;
import demo.pages.MessagesPage;
import demo.pages.SignInPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
import static org.testng.Assert.*;

/**
 * Created by Артем on 28.03.2017.
 */
public class TestSendingMessages extends BaseTest {
    private String senderLogin;
    private String senderPassword;
    private String addresseeLogin;
    private String addresseePassword;
    private String themeOfMessage;
    private String textOfMessage;

    @Parameters({"senderLogin", "senderPass","themeOfMessage", "textOfMessage", "addresseeLogin", "addresseePassword"})
    @BeforeTest
    public void setup(String senderLogin, String senderPassord, String themeOfMessage, String textOfMessage,
                      String addresseeLogin, String addresseePassword){
        this.senderLogin = senderLogin;
        this.senderPassword = senderPassord;
        this.themeOfMessage = themeOfMessage;
        this.textOfMessage = textOfMessage;
        this.addresseeLogin = addresseeLogin;
        this.addresseePassword = addresseePassword;
    }

    @Override
    public void runTest(){
        MainPageOnliner mainPageOnliner = new MainPageOnliner();

        CommonElements commonElements = new CommonElements();
        commonElements.enterToAccount();

        SignInPage signInPage = new SignInPage();
        signInPage.signIn(senderLogin, senderPassword);

        assertTrue(commonElements.checkSuccessfulLogin(senderLogin));
        commonElements.navigateOnUserMenu("Cообщения");

        MessagesPage messagesPage = new MessagesPage();
        messagesPage.navigateOnMessageMenu("Написать");
        messagesPage.enterAddressee(addresseeLogin);
        messagesPage.enterHeading(themeOfMessage);
        messagesPage.enterMessage(textOfMessage);
        messagesPage.submitMessage();

        commonElements.navigateOnUserMenu("Выйти");

        signInPage.signIn(addresseeLogin, addresseePassword);

        assertTrue(commonElements.checkSuccessfulLogin(addresseeLogin));

        messagesPage.navigateOnMessageMenu("Входящие");
        messagesPage.openMessageByTheme(themeOfMessage);

        String actHeading = messagesPage.getHeadingOfMessage();
        String actSender = messagesPage.getSender();
        String actTextMsg = messagesPage.getTextOfMessage();

        assertTrue(actHeading.equals(themeOfMessage)
                && actSender.equals(senderLogin)
                && actTextMsg.equals(textOfMessage));

        commonElements.navigateOnUserMenu("Выйти");
    }
}