package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {
    static ExtentReports extent = ExtentManager.getInstance();
    static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setup(Scenario s) {
        DriverFactory.initDriver();
        test.set(extent.createTest(s.getName()));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            // Clean file name (important)
            String testName = scenario.getName().replaceAll(" ", "_");

            // Capture screenshot (absolute path)
            String fullPath = ScreenshotUtil.capture(testName);

            // Relative path for report
            String relativePath = "./screenshots/" + testName + ".png";

            test.get().fail("Test Failed")
                    .addScreenCaptureFromPath(relativePath);

        } else {
            test.get().pass("Test Passed");
        }

        DriverFactory.getDriver().quit();
        extent.flush();
    }
}