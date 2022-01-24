package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("https://www.flipkart.com/");
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Login']/ancestor::div/div/div")));

        WebElement closeButton = driver.findElement(By.xpath("//span[text()='Login']/ancestor::div/div/div/button"));
        closeButton.click();

        System.out.println(driver.getTitle());

        //takeScreenShot(driver, "./screen.png");

        // "Samsung Galaxy S10"

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Samsung Galaxy S10");

        WebElement searchButton = driver.findElement(with(By.tagName("button")).near(searchBox));

        searchButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Showing 1 –')]")));

        //takeScreenShot(driver, "./screen2.png");

        Thread.sleep(5000);

        Assert.assertTrue(driver.getTitle().matches("(?i)BrowserStack - Google Search"));
    }
}
