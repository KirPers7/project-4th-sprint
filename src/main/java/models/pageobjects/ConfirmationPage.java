package models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {
    //Кнопка подтверждения создания нового заказа
    public static final By CONFIRMATION_YES_BUTTON = By.xpath(".//button[text() = 'Да']");

    private final WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYesOnConfirmationForm() {
        WebElement selectYesOnConfirmationForm = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_YES_BUTTON));
        selectYesOnConfirmationForm.click();
    }

}
