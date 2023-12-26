package org.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class Login {

    public static void loginuser(WebDriver driver, WebDriverWait wait) {
        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logInModal")));
        WebElement username = driver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
        username.sendKeys("Musadiq5828");
        password.sendKeys("123");
        login.click();

        // Wait for the login to complete
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Login.loginuser(driver, wait);

        // Find the product after logging in
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
        product.click();

        // Add the product to the cart
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        WebElement cart= driver.findElement(By.xpath("//*[@id=\"cartur\"]"));
        cart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")));
        WebElement PlaceOrder= driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
        PlaceOrder.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        WebElement name=driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement CreditCard= driver.findElement(By.xpath("//*[@id=\"card\"]"));
        WebElement Purchase= driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
//        WebElement ok=driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
        name.click();
        name.sendKeys("MUSADIQ MUSTAFA");
        CreditCard.click();
        CreditCard.sendKeys("550550550");
        Purchase.click();
        WebElement ok=driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div[7]/div/button")));
        ok.click();






    }
}
