package models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentConditionsPage {
    //Поле-календарь "Когда привезти самокат"
    public static final By SCOOTER_DELIVERY_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Выбор текущей даты из календаря
    public static final By SELECT_SCOOTER_DELIVERY_DATE = By.cssSelector("div[class*='react-datepicker__day--today']");
    //Поле-селектор "Срок аренды"
    public static final By SELECT_RENTAL_PERIOD = By.xpath(".//div[text()='* Срок аренды']");
    //Комбобокс "Цвет самоката"
    public static final By CHECK_COLOR_BLACK = By.id("black");
    public static final By CHECK_COLOR_GREY = By.id("grey");
    //Кнопка "Заказать" на форме оформления заказа
    public static final By MAKE_ORDER_FORM_BUTTON = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM')]");

    private final WebDriver driver;

    public RentConditionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputRentFieldsInNewOrder() {
        WebElement selectScooterDeliveryDate = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(SCOOTER_DELIVERY_DATE));
        selectScooterDeliveryDate.click();
        driver.findElement(SELECT_SCOOTER_DELIVERY_DATE).click();
        driver.findElement(SELECT_RENTAL_PERIOD).click();
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
        driver.findElement(CHECK_COLOR_BLACK).click();
        driver.findElement(MAKE_ORDER_FORM_BUTTON).click();
    }
}
