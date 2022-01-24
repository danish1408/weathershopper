package weathershopper.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import weathershopper.base.BaseClass;

public class MoisturizersPage extends BaseClass {

    @FindBy(xpath = "//h2[text()=\"Moisturizers\"]")
    WebElement moisturizers;


    public  String getMoisturizersPageName(){

    return moisturizers.getText();

    }
    public MoisturizersPage(){

        PageFactory.initElements(driver, this);
    }





}

