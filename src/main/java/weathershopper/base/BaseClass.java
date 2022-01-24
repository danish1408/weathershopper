package weathershopper.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public static String path= "src//main/java//weathershopper//Config//config.properties";
    public static String lower_temp;
    public static String high_temp;


  public  BaseClass() {

        try {

            prop = new Properties();

            FileInputStream fls = new FileInputStream(path);
            prop.load(fls);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
       lower_temp =  prop.getProperty("lowerTemp");
       high_temp =  prop.getProperty("highTemp");


        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("url"));
        } else if (browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));


    }


}