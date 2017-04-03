package demo.tests;

import demo.menu.CommonElements;
import demo.pages.MainPageOnliner;
import demo.pages.MessagesPage;
import demo.pages.SignInPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

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
        logStep();
        MainPageOnliner mainPageOnliner = new MainPageOnliner();

        logStep();
        CommonElements commonElements = new CommonElements();
        commonElements.enterToAccount();

        logStep();
        SignInPage signInPage = new SignInPage();
        signInPage.signIn(senderLogin, senderPassword);

        logStep();
        commonElements.checkSuccessfulLogin(senderLogin);
        commonElements.navigateOnUserMenu("Cообщения");

        logStep();
        MessagesPage messagesPage = new MessagesPage();
        messagesPage.navigateOnMessageMenu("Написать");
        messagesPage.enterAddressee(addresseeLogin);
        messagesPage.enterHeading(themeOfMessage);
        messagesPage.enterMessage(textOfMessage);
        messagesPage.submitMessage();

        logStep();
        commonElements.navigateOnUserMenu("Выйти");

        logStep();
        signInPage.signIn(addresseeLogin, addresseePassword);

        logStep();
        commonElements.checkSuccessfulLogin(addresseeLogin);

        logStep();
        messagesPage.navigateOnMessageMenu("Входящие");
        messagesPage.openMessageByTheme(themeOfMessage);

        logStep();
        messagesPage.assertTrueMessage(senderLogin, themeOfMessage, textOfMessage);

        logStep();
        commonElements.navigateOnUserMenu("Выйти");
    }
}