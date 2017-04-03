package demo.tests;

import demo.menu.CommonElements;
import demo.pages.AutobaraholkaPage;
import demo.pages.MainPageOnliner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
/**
 * Created by Артем on 29.03.2017.
 */
public class TestSorting extends BaseTest {
    String model;

    @Parameters({"model"})
    @BeforeTest
    public void setup(String model){
        this.model = model;
    }

    @Override
    public void runTest(){
        logStep();
        MainPageOnliner mainPageOnliner = new MainPageOnliner();

        logStep();
        CommonElements commonElements = new CommonElements();
        commonElements.navigateOnMainMenu("Автобарахолка");

        logStep();
        AutobaraholkaPage autobaraholkaPage = new AutobaraholkaPage();
        autobaraholkaPage.selectModel(model);
        autobaraholkaPage.sortByPrice();

        logStep();
        autobaraholkaPage.checkOrder();
    }
}