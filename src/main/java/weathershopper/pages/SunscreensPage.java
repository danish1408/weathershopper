package weathershopper.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import weathershopper.base.BaseClass;

public class SunscreensPage extends BaseClass {
    @FindBy(xpath = "//h2[text()=\"Sunscreens\"]")
    WebElement sunscreens;

    public  String getSunscreensPageName(){

        return sunscreens.getText();

    }

    public SunscreensPage(){
        PageFactory.initElements(driver, this);
}




}

