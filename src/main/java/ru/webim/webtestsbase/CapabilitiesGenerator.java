package ru.webim.webtestsbase;

import org.openqa.selenium.remote.DesiredCapabilities;


public class CapabilitiesGenerator {

    /**
     * getting {@link org.openqa.selenium.remote.DesiredCapabilities} object based on browser
     * ATTENTION: you should specify the path to chrome driver executable file to run tests on it(@see <a href="https://sites.google.com/a/chromium.org/chromedriver/getting-started">here for more info</a>)
     * @param browser {@link Browser} object
     * @return capabilites needed for some browsers start
     */
    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return DesiredCapabilities.firefox();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); //костыль, прописываю путь в path, но не заводится
               if (System.getProperty("webdriver.chrome.driver") == null) {
                   throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.chrome();
            case IE10:
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setVersion("10");
                return caps;
            case SAFARI:
                return new DesiredCapabilities();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

}
