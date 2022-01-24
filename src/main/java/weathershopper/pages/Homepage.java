package weathershopper.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import weathershopper.base.BaseClass;

   public class Homepage extends BaseClass {
    @FindBy(xpath= "//*[@id=\"temperature\"]")
    WebElement temperature;

    @FindBy(xpath= "//a[@href='/moisturizer']")

    WebElement moisturizers;

    @FindBy(xpath = "//a[@href='/sunscreen']")

    WebElement sunscreens;


    public Homepage(){

        PageFactory.initElements(driver, this);
    }

    public String getTemperature(){


        return temperature.getText();
    }



public MoisturizersPage clickMoisturizers(){
   moisturizers.click();
   return new MoisturizersPage();
}


     public SunscreensPage  clickSunscreens(){
         sunscreens.click();
         return new SunscreensPage();
       }

}
