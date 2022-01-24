package weathershopper.util;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import weathershopper.base.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.LocalDateTime;




public class TestUtil extends BaseClass {

    public static String takeScreenshotAtEndOfTest() throws IOException{

        System.out.println("take Screenshot");

      LocalDateTime localDateTime = LocalDateTime.now();
        String currDate = localDateTime.toString();
        String screenshotname =  driver.getTitle() + ".png";

        String destination = "C://Users//admin//IdeaProjects//weathershopper//src//test//TestOutput//" + screenshotname;

//                "." + File.separator + "src" + File.separator +  "test" + File.separator + "TestOutput" + File.separator + "screenshot_" + currDate +
//                 ".png";

        System.out.println(destination);



       TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File finalDestination = new File(destination);
        System.out.println("File Exception");
        FileUtils.copyFile(source, finalDestination);

    return destination;
    }


}
