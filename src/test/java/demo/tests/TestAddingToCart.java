package demo.tests;

import demo.menu.CommonElements;
import demo.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Артем on 31.03.2017.
 */
public class TestAddingToCart extends BaseTest{
    private String login;
    private String password;
    private String section;

    @Parameters({"login", "password", "section"})
    @BeforeTest
    public void setup(String login, String password, String section){
        this.login = login;
        this.password = password;
        this.section = section;
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
        signInPage.signIn(login, password);

        logStep();
        commonElements.checkSuccessfulLogin(login);

        logStep();
        commonElements.navigateOnMainMenu("Каталог");

        logStep();
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateOnCatalogMenu(section);

        logStep();
        CamerasPage camerasPage = new CamerasPage();
        camerasPage.openFirst();

        logStep();
        ConcreteProductPage concreteProductPage = new ConcreteProductPage();
        String nameOfProduct = concreteProductPage.getNameOfProduct();
        concreteProductPage.openOffers();

        logStep();
        OffersPage offersPage = new OffersPage();
        offersPage.addToCart();

        logStep();
        commonElements.openCart();

        logStep();
        CartPage cartPage = new CartPage();
        String productFormCart = cartPage.getNameOfFirstProduct();

        logStep();
        cartPage.assertTrueProduct(nameOfProduct, productFormCart);

        logStep();
        cartPage.deleteFromCart();
    }
}
