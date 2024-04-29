import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Homework5 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43");
    }

    @Test
    public void checkout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addCartButton = driver.findElement(By.id("button-cart"));
        addCartButton.click();
        WebElement cartItemButton = driver.findElement(By.id("cart-total"));
        cartItemButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart .fa.fa-share")));
        WebElement checkoutButton = driver.findElement(By.cssSelector("#cart .fa.fa-share"));
        checkoutButton.click();

        String titleCheckout = driver.getTitle();
        Assert.assertEquals(titleCheckout, "Checkout");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
