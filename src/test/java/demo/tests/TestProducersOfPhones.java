package demo.tests;

import demo.menu.CommonElements;
import demo.pages.CatalogPage;
import demo.pages.MainPageOnliner;
import demo.pages.MobilePhonesPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

/**
 * Created by Артем on 30.03.2017.
 */
public class TestProducersOfPhones extends BaseTest {
    private String producer;

    @Parameters({"producer"})
    @BeforeTest
    public void setup(String producer){
        this.producer = producer;
    }

    @Override
    public void runTest(){
        logStep();
        MainPageOnliner mainPageOnliner = new MainPageOnliner();

        logStep();
        CommonElements commonElements = new CommonElements();
        commonElements.navigateOnMainMenu("Каталог");

        logStep();
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateOnCatalogMenu("Мобильные телефоны");

        logStep();
        MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
        mobilePhonesPage.checkCountOfFilters();
        mobilePhonesPage.setProducer(producer);

        logStep();
        mobilePhonesPage.assertTrueProducers(producer);
    }
}
