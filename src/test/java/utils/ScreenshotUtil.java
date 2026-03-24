package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtil {
    public static String capture(String name){
        name = name.replaceAll(" ", "_");
        String path = System.getProperty("user.dir") + "/target/screenshots/" + name + ".png";

        File src = ((TakesScreenshot)DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        try {
            File directory = new File(System.getProperty("user.dir") + "/target/screenshots/");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}