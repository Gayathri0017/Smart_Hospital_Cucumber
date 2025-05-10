package com.actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.utils.HelperClass;
public class VerifyLinksAction_Doctor {
int vl=0,bl=0;
public void verifyLinks(){
	List<WebElement> links=HelperClass.getDriver().findElements(By.tagName("a"));
    for (WebElement link : links) {
        String href=link.getAttribute("href");
        if (href==null || href.isEmpty() || href.startsWith("javascript:") || href.startsWith("mailto:")) {
            continue;
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(href).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int code = conn.getResponseCode();
            String message = conn.getResponseMessage();
            if (code!=200) {
                System.out.println("Broken Link: "+href + " -Code: " + code + "-"+message);
                bl++;
            } else {
                System.out.println("Valid Link: "+href + " - Code: " + code);
                vl++;
            }
        } catch (Exception e) {
            System.out.println("Error checking link: "+href + " -" + e.getMessage());
        }
    }
}
public void getCount() {
	System.out.println("Number of Valid Links in Doctor Login: "+vl);
	System.out.println("Number of Broken Links in Doctor Login: "+bl);
}
}
