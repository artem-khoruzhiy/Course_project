package demo.tests;

import demo.menu.CommonElements;
import demo.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
import static org.testng.Assert.*;

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
        MainPageOnliner mainPageOnliner = new MainPageOnliner();

        CommonElements commonElements = new CommonElements();
        commonElements.enterToAccount();

        SignInPage signInPage = new SignInPage();
        signInPage.signIn(login, password);
        assertTrue(commonElements.checkSuccessfulLogin(login));

        commonElements.navigateOnMainMenu("Каталог");

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateOnCatalogMenu(typeOfProduct);

        ProductsPage productsPage = new ProductsPage();
        productsPage.openFirstProduct();

        ConcreteProductPage concreteProductPage = new ConcreteProductPage();
        concreteProductPage.addToBookmarks();
        String nameOfProduct = concreteProductPage.getNameOfProduct();

        commonElements.navigateOnUserMenu("Закладки");

        BookmarksPage bookmarksPage = new BookmarksPage();
        bookmarksPage.navigateOnBookmarksMenu("Каталог");

        BookmarksCatalog bookmarksCatalog = new BookmarksCatalog();
        String nameFromBookmarks = bookmarksCatalog.getNameOfFirstProductFromBookmarks();

        assertTrue(nameOfProduct.contains(nameFromBookmarks));

        commonElements.navigateOnUserMenu("Выйти");
    }
}