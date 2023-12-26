package org.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {
    public static void main (String[] args ){
        System.out.println("herllo");
        WebDriver driver =new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert1 =driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        WebElement alert2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        WebElement alert3=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        alert1.click();
        Alert alert_one=driver.switchTo().alert();

        System.out.println(alert_one.getText());
        alert_one.accept();
        alert2.click();
        Alert alert_two=driver.switchTo().alert();
        System.out.println(alert_two.getText());
        alert_two.accept();

        alert3.click();
        Alert alert_three=driver.switchTo().alert();
        alert_three.sendKeys("And I am Superman");
        System.out.println(alert_three.getText());
        alert_three.accept();





    }

}
