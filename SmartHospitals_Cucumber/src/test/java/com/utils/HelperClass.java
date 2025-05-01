package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HelperClass {
    private static ConcurrentHashMap<String, WebDriver> drivers = new ConcurrentHashMap<>();

    public static WebDriver getDriver() {
        String threadName = Thread.currentThread().getName();
        if (!drivers.containsKey(threadName)) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
                put("credentials_enable_service", false);
                put("profile.password_manager_enabled", false);
                // Set the download directory
                put("download.default_directory", "D:\\eclipse1\\Smart_Hospital_Cucumber\\SmartHospitals_Cucumber\\ReportDownlode");
                put("download.prompt_for_download", false);
                put("download.directory_upgrade", true);
                put("safebrowsing.enabled", true);
            }});

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://demo.smart-hospital.in/site/login");
            drivers.put(threadName, driver);
        }
        return drivers.get(threadName);
    }

    public static void quitDriver() {
        String threadName = Thread.currentThread().getName();
        if (drivers.containsKey(threadName)) {
            WebDriver driver = drivers.get(threadName);
            if (driver != null) {
                driver.close();
                driver.quit();
            }
            drivers.remove(threadName);
        }
    }
}