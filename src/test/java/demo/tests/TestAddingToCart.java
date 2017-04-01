package demo.tests;

import demo.menu.CommonElements;
import demo.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
import static org.testng.Assert.*;

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
        MainPageOnliner mainPageOnliner = new MainPageOnliner();

        CommonElements commonElements = new CommonElements();
        commonElements.enterToAccount();

        SignInPage signInPage = new SignInPage();
        signInPage.signIn(login, password);

        assertTrue(commonElements.checkSuccessfulLogin(login));
        commonElements.navigateOnMainMenu("Каталог");

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateOnCatalogMenu(section);

        CamerasPage camerasPage = new CamerasPage();
        camerasPage.openFirst();

        ConcreteProductPage concreteProductPage = new ConcreteProductPage();
        String nameOfProduct = concreteProductPage.getNameOfProduct();
        concreteProductPage.openOffers();

        OffersPage offersPage = new OffersPage();
        offersPage.addToCart();

        commonElements.openCart();

        CartPage cartPage = new CartPage();
        String productFormCart = cartPage.getNameOfFirstProduct();

        assertTrue(nameOfProduct.contains(productFormCart));

        cartPage.deleteFromCart();
    }
}
