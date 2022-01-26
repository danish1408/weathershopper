package weathershopperTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import weathershopper.base.BaseClass;
import weathershopper.pages.Homepage;
import weathershopper.pages.MoisturizersPage;
import weathershopper.pages.SunscreensPage;
import weathershopper.util.TestUtil;
/* This is the Actual Test reads the Temperature on home page and Click on the Basis on below Validation
* Shop for moisturizers if the weather is below 19 degrees.
* Shop for suncreens if the weather is above 34 degrees.
 */
public class HomePageTest extends BaseClass  {
    Homepage homePage;
    MoisturizersPage moisturizersPage;
    SunscreensPage sunscreensPage;
    String screenshotPath;

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
          String temp = homePage.getTemperature();
            String stemp = temp.substring(0, 2);
            Integer itemp = Integer.parseInt(stemp.trim());
            Integer l_temp = Integer.parseInt(BaseClass.lower_temp);
            Integer h_temp = Integer.parseInt(BaseClass.high_temp);
            if (itemp < l_temp) {
                homePage.clickMoisturizers();
                String pageName = moisturizersPage.getMoisturizersPageName();
                Assert.assertEquals(pageName, "Moisturizers");
                TestUtil.takeScreenshotAtEndOfTest();
                } else if (itemp > h_temp) {
                homePage.clickSunscreens();
                String pageName = sunscreensPage.getSunscreensPageName();
                Assert.assertEquals(pageName, "Sunscreens");
                  TestUtil.takeScreenshotAtEndOfTest();
                  }
        }
        catch (Exception e){
            System.out.println(e);
            TestUtil.takeScreenshotAtEndOfTest();
        }
        catch (Error e){
               System.out.println(e);
            TestUtil.takeScreenshotAtEndOfTest();
        }
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}


