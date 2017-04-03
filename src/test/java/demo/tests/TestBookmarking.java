package demo.tests;

import demo.menu.CommonElements;
import demo.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Артем on 28.03.2017.
 */
public class TestBookmarking extends BaseTest {
    private String login;
    private String password;
    private String typeOfProduct;

    @Parameters({"login", "password", "typeOfProduct"})
    @BeforeTest
    public void setup(String login, String password, String typeOfProduct){
        this.login = login;
        this.password = password;
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public void runTest() {
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
        commonElements.navigateOnMainMenu("Каталог");

        logStep();
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateOnCatalogMenu(typeOfProduct);

        logStep();
        ProductsPage productsPage = new ProductsPage();
        productsPage.openFirstProduct();

        logStep();
        ConcreteProductPage concreteProductPage = new ConcreteProductPage();
        concreteProductPage.addToBookmarks();
        String nameOfProduct = concreteProductPage.getNameOfProduct();

        logStep();
        commonElements.navigateOnUserMenu("Закладки");

        logStep();
        BookmarksPage bookmarksPage = new BookmarksPage();
        bookmarksPage.navigateOnBookmarksMenu("Каталог");

        logStep();
        BookmarksCatalog bookmarksCatalog = new BookmarksCatalog();
        String nameFromBookmarks = bookmarksCatalog.getNameOfFirstProductFromBookmarks();

        logStep();
        bookmarksCatalog.assertTrueProductInBookmarks(nameFromBookmarks, nameOfProduct);

        logStep();
        commonElements.navigateOnUserMenu("Выйти");
    }
}