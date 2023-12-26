package org.automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium4 {
    public static void main(String[] args ){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoblaze.com/");
        String OrginalWindow=driver.getWindowHandle();
        driver.getTitle();
        System.out.println(driver.getTitle());
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().window(OrginalWindow);
    }
}
