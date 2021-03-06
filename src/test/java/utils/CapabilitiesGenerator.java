package utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class CapabilitiesGenerator {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String driverPath = "src/test/resources/webdrivers";
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(("Operational system: " + os + "; Driver path: " + driverPath));
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + "/linux/chromedriver.exe");
        }
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");



        return options;
    }
}
