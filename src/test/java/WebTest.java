import io.github.bonigarcia.wdm.WebDriverManager;
import models.MainPage;
import models.pageobjects.ConfirmationPage;
import models.pageobjects.Created;
import models.pageobjects.CustomerPage;
import models.pageobjects.RentConditionsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class WebTest {

    private WebDriver driver;

    //Ответ на вопрос 1
    private static final By ANSWER_ON_FIRST_QUESTION = By.id("accordion__panel-0");

    private final String nameCustomer;
    private final String surnameCustomer;
    private final String address;
    private final String phone;

    public WebTest(String nameCustomer, String surnameCustomer, String address, String phone) {
        this.nameCustomer = nameCustomer;
        this.surnameCustomer = surnameCustomer;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Иван", "Матроскин", "Москва", "89041445566"},
                {"Макар", "Фартуков", "Москва", "89170054896"}
        };
    }


    @Before
    public void setUp () {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void checkFindImportantQuestions() {
        MainPage mainPage = new MainPage(driver);
        mainPage.findImportantQuestion();
        //new WebDriverWait(driver, 10)
                //.until(ExpectedConditions.visibilityOfElementLocated(CLICK_ON_FIRST_QUESTION));
         //WebElement element = driver.findElement(CLICK_ON_FIRST_QUESTION);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        //driver.findElement(CLICK_ON_FIRST_QUESTION).click();
        String actual = driver.findElement(ANSWER_ON_FIRST_QUESTION).getText();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expected, actual);
    }

    @Test
    public void createNewOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateOrderButtonTop();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.inputCustomersFieldsInNewOrder(nameCustomer, surnameCustomer, address, phone);
        RentConditionsPage rentConditionsPage = new RentConditionsPage(driver);
        rentConditionsPage.inputRentFieldsInNewOrder();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.clickYesOnConfirmationForm();
        Created created = new Created(driver);
        created.checkOrderCreated();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
