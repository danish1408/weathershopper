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

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

//This Is Utility Class for Capturing Screnshot
public class TestUtil extends BaseClass {
    static String destination;

    public static String takeScreenshotAtEndOfTest() {

        try {

            LocalDateTime localDateTime = LocalDateTime.now();
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String screenshotname = driver.getTitle() + dateName + ".jpeg";
            destination = System.getProperty("user.dir") + "/src/test/TestOutput/" + screenshotname;
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination, true);

        } catch (Exception e) {
            System.out.println(e);
        }

        return destination;

    }

}
