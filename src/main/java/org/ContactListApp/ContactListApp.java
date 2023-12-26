package org.ContactListApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class ContactListApp {
    WebDriver driver;
    WebDriverWait wait;
    WebElement firstname;


    @BeforeTest
    void setup(){
       driver =new ChromeDriver();
    }

    @Test
    void tc_01(){
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
        WebElement Signup=driver.findElement(By.xpath("//*[@id=\"signup\"]"));
        Signup.click();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/h1")));
        WebElement firstname= driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstname.click();
        firstname.sendKeys("Musadiq");
        WebElement lastname= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastname.click();
        lastname.sendKeys("Mustafa");
        WebElement email=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/p[3]/input[1]"));
        String baseEmail = "musadiqmustafa";
        String randomEmail = baseEmail + UUID.randomUUID().toString().substring(0, 8) + "@gmail.com";
        email.click();
        email.sendKeys(randomEmail);
        WebElement password= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/p[4]/input[1]"));
        password.click();
        password.sendKeys("12345678");
        WebElement Submit= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/p[2]/button[1]"));
        Submit.click();



    }
    @Test
    void tc_02(){
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
        WebElement Signup=driver.findElement(By.xpath("//*[@id=\"signup\"]"));
        Signup.click();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/h1")));
        WebElement firstname= driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstname.click();
        firstname.sendKeys("Musadiq");
        WebElement lastname= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastname.click();
        lastname.sendKeys("Mustafa");


        WebElement password = driver.findElement(By.xpath("/html/body/div/form/p[4]/input"));
        password.click();
        password.sendKeys("12345678");

        WebElement Submit = driver.findElement(By.xpath("/html/body/div/p[2]/button"));
        Submit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/span")));
        WebElement ValidationError = driver.findElement(By.xpath("/html/body/div/span"));

        String expectedErrorMessage = "User validation failed: email: Email is invalid";
        String actualErrorMessage = ValidationError.getText();
        System.out.println("Actual Error Message: " + actualErrorMessage);

        assert actualErrorMessage.contains(expectedErrorMessage) : "Validation error message is not as expected.";




    }


}

