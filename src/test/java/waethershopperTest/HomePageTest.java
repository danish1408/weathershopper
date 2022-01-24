package waethershopperTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import weathershopper.base.BaseClass;
import weathershopper.pages.Homepage;
import weathershopper.pages.MoisturizersPage;
import weathershopper.pages.SunscreensPage;
import weathershopper.util.TestUtil;

public class HomePageTest extends BaseClass  {

    Homepage homePage;
    MoisturizersPage moisturizersPage;
    SunscreensPage sunscreensPage;
    @BeforeTest
    public void setUp() throws InterruptedException {
        initialization();
        homePage = new Homepage();
        moisturizersPage = new MoisturizersPage();
        sunscreensPage =new SunscreensPage();

    }
    @Test(testName = " verifyTemperature and click accordingly")


    public void navigatetoshoppingList() {

        try{

            TestUtil.takeScreenshotAtEndOfTest();
            String temp = homePage.getTemperature();

            String stemp = temp.substring(0, 2);
            Integer itemp = Integer.parseInt(stemp.trim());
            Integer l_temp = Integer.parseInt(BaseClass.lower_temp);
            Integer h_temp = Integer.parseInt(BaseClass.high_temp);
            if (itemp < l_temp) {
                homePage.clickMoisturizers();
                String pageName = moisturizersPage.getMoisturizersPageName();

                Assert.assertEquals(pageName, "Moisturizers");
            } else if (itemp > h_temp) {
                homePage.clickSunscreens();

                String pageName = sunscreensPage.getSunscreensPageName();

                Assert.assertEquals(pageName, "Sunscreens");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        catch (Error e){
            System.out.println(e);
        }


    }

    @AfterTest

    public void teardown()
    {
        driver.quit();
    }
}


