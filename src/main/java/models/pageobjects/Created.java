package models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Created {
    public static final By ORDER_CREATED = By.xpath(".//div[text()='Заказ оформлен']");

    private final WebDriver driver;

    public Created(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderCreated() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_CREATED));
    }
}
