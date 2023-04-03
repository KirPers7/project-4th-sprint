package models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //Кнопка принятия cookie
    private static final By APP_COOKIE = By.className("App_CookieButton__3cvqF");
    //Кнопка "Заказать" на главной странице (наверху)
    private static final By CHECK_ORDER_BUTTON_TOP = By.xpath(".//button[(@class='Button_Button__ra12g') and (text()='Заказать')]");
    //Вопросы о важном: 1. "Сколько это стоит? И как оплатить?"
    private static final By CLICK_ON_FIRST_QUESTION = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
    }

    public void findImportantQuestion() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CHECK_ORDER_BUTTON_TOP));
        WebElement element = driver.findElement(CLICK_ON_FIRST_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(CLICK_ON_FIRST_QUESTION).click();
    }

    public void clickCreateOrderButtonTop() {
        WebElement activeOrderButtonTop = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CHECK_ORDER_BUTTON_TOP));
        activeOrderButtonTop.click();
        driver.findElement(APP_COOKIE).click();
    }
}
