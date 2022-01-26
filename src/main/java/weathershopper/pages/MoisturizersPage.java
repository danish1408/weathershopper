package weathershopper.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import weathershopper.base.BaseClass;

//Page Object Factory for MoisturizerPage

public class MoisturizersPage extends BaseClass {

    @FindBy(xpath = "//h2[text()=\"Moisturizers\"]")
    WebElement moisturizers;

    //Reading Page Name
    public  String getMoisturizersPageName(){

    return moisturizers.getText();

    }
    //Initializing Page Factory
    public MoisturizersPage(){

        PageFactory.initElements(driver, this);
    }





}

