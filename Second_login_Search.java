package Login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import javax.xml.ws.Action;

import org.testng.annotations.Test;

import com.sun.org.glassfish.gmbal.Description;

import jdk.nashorn.internal.objects.annotations.Setter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */
/**
 * @author Emerald
 *
 */

public class Second_login_Search {

	private static final String WEB_DRIVER_CHROME = "webdriver.chrome.driver";
	private static final String PATH_SELENIUM = "F://Selenium//chromedriver.exe";
	private static final String URL = "https://221616.com/connect";
	private WebDriver driver;
	private ChromeOptions options;
	private WebDriverWait wait;

	@BeforeTest
	public void setup() {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty(WEB_DRIVER_CHROME, PATH_SELENIUM);
		driver = new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 60);
	}

	@SuppressWarnings({})
	@Test(priority = 1)
	public void login() throws InterruptedException {
		WebElement loginBtn = driver.findElement(By.xpath("/html/body/header/p[2]"));
		loginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("container")));

//		driver.findElement(By.className("container"));
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"save_email\"]"));
		Email.sendKeys("bich.ttn+03@glv.co.jp");

		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"save_password\"]"));
		pwd.sendKeys("123456");

		WebElement Loginbtn = driver.findElement(By.xpath("//*[@id=\"CP1020Login\"]/button"));// *[@id="CP1020Login"]/button
		Loginbtn.click();
		Thread.sleep(20);

		System.out.println("Welcome!");
	}

	private static final By DROPDOWN_MAKER_BY_ID = By.id("dropdown_maker");
	private static final By DROPDOWN_MODEL_BY_ID = By.id("dropdown_model");
	private static final By DROPDOWN_GRADE_BY_ID = By.id("dropdown_grade");
	private static final By DROPDOWN_TYPE_BY_ID = By.id("Type");
	private static final By DROPDOWN_NENSIKI_START_BY_ID = By.id("NensikiStart");
	private static final By DROPDOWN_NENSIKI_END_BY_ID = By.id("NensikiEnd");
	private static final By DROPDOWN_PRICE_START_BY_ID = By.id("PriceStart");
	private static final By DROPDOWN_PRICE_END_BY_ID = By.id("PriceEnd");
	private static final By DROPDOWN_DISTANCE_KM_START_BY_ID = By.id("DistanceKmStart");
	private static final By DROPDOWN_DISTANCE_KM_END_BY_ID = By.id("DistanceKmEnd");
	private static final By DROPDOWN_NO_OF_SEATS_START_BY_ID = By.id("NoOfSeatsStart");
	private static final By DROPDOWN_NO_OF_SEATS_END_BY_ID = By.id("NoOfSeatsEnd");
	private static final By DROPDOWN_NO_OF_DOORS_START_BY_ID = By.id("NoOfDoorsStart");
	private static final By DROPDOWN_NO_OF_DOORS_END_BY_ID = By.id("NoOfDoorsEnd");
	private static final By DROPDOWN_DISPLACEMENT_START_BY_ID = By.id("DisplacementStart");
	private static final By DROPDOWN_DISPLACEMENT_END_BY_ID = By.id("DisplacementEnd");
	private static final By DROPDOWN_MISSION_BY_ID = By.id("Mission");
	private static final By DROPDOWN_INSPECTION_DATE_BY_ID = By.id("InspectionDate");
	private static final By CHECKBOX_COLOR_ONE_BY_ID = By.id("C_101");
	private static final By CHECKBOX_COLOR_TWO_BY_ID = By.id("C_102");
	private static final By BUTTON_SEARCH_BY_ID = By.id("btn_search");
	private static final By BUTTON_TOGGLE_REFINE_MENU_BY_ID = By.id("btn_toggle_refine_menu");

	@Test(priority = 3)
	public void searchNoResult() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_MAKER_BY_ID));
		new Select(driver.findElement(DROPDOWN_MAKER_BY_ID)).selectByVisibleText("トヨタ");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_MODEL_BY_ID));
		new Select(driver.findElement(DROPDOWN_MODEL_BY_ID)).selectByVisibleText("アルファード");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_GRADE_BY_ID));
		new Select(driver.findElement(DROPDOWN_GRADE_BY_ID)).selectByVisibleText("エグゼクティブ ラウンジ");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_TYPE_BY_ID));
		new Select(driver.findElement(DROPDOWN_TYPE_BY_ID)).selectByVisibleText("ミニバン/ワゴン/1BOX");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_NENSIKI_START_BY_ID));
		new Select(driver.findElement(DROPDOWN_NENSIKI_START_BY_ID)).selectByVisibleText("H12/2000年");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_NENSIKI_END_BY_ID));
		new Select(driver.findElement(DROPDOWN_NENSIKI_END_BY_ID)).selectByVisibleText("H20/2008年");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_PRICE_START_BY_ID));
		new Select(driver.findElement(DROPDOWN_PRICE_START_BY_ID)).selectByVisibleText("10万円");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_PRICE_END_BY_ID));
		new Select(driver.findElement(DROPDOWN_PRICE_END_BY_ID)).selectByVisibleText("30万円");
		Thread.sleep(1000);

		driver.findElement(BUTTON_TOGGLE_REFINE_MENU_BY_ID).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_DISTANCE_KM_START_BY_ID));
		new Select(driver.findElement(DROPDOWN_DISTANCE_KM_START_BY_ID)).selectByVisibleText("1万km");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_DISTANCE_KM_END_BY_ID));
		new Select(driver.findElement(DROPDOWN_DISTANCE_KM_END_BY_ID)).selectByVisibleText("4万km");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_NO_OF_SEATS_START_BY_ID));
		new Select(driver.findElement(DROPDOWN_NO_OF_SEATS_START_BY_ID)).selectByVisibleText("1人");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_NO_OF_SEATS_END_BY_ID));
		new Select(driver.findElement(DROPDOWN_NO_OF_SEATS_END_BY_ID)).selectByVisibleText("4人");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_NO_OF_DOORS_START_BY_ID));
		new Select(driver.findElement(DROPDOWN_NO_OF_DOORS_START_BY_ID)).selectByVisibleText("1");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_NO_OF_DOORS_END_BY_ID));
		new Select(driver.findElement(DROPDOWN_NO_OF_DOORS_END_BY_ID)).selectByVisibleText("3");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_DISPLACEMENT_START_BY_ID));
		driver.findElement(DROPDOWN_DISPLACEMENT_START_BY_ID).sendKeys("2");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_DISPLACEMENT_END_BY_ID));
		driver.findElement(DROPDOWN_DISPLACEMENT_END_BY_ID).sendKeys("4");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_MISSION_BY_ID));
		new Select(driver.findElement(DROPDOWN_MISSION_BY_ID)).selectByVisibleText("AT");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_INSPECTION_DATE_BY_ID));
		new Select(driver.findElement(DROPDOWN_INSPECTION_DATE_BY_ID)).selectByVisibleText("半年未満");
		Thread.sleep(1000);

		driver.findElement(BUTTON_SEARCH_BY_ID).click();

		WebElement response = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"recommend-area\"]/div[1]/div[2]/p/b")));
		String noOfResult = response.getText();
		System.out.println("The error is: " + response.getText());

		boolean isExpected = true;

		boolean isResult = noOfResult.length() > 0;

		Assert.assertEquals(isExpected, isResult);
	}

	@Test(priority = 2)
	public void searchWithResult() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_MAKER_BY_ID));
		new Select(driver.findElement(DROPDOWN_MAKER_BY_ID)).selectByVisibleText("トヨタ");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN_MODEL_BY_ID));
		new Select(driver.findElement(DROPDOWN_MODEL_BY_ID)).selectByVisibleText("アルファード");
		Thread.sleep(1000);

		driver.findElement(BUTTON_SEARCH_BY_ID).click();

		WebElement response = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_sort_area\"]/div[2]")));

		System.out.println("The result is: " + response.getText());

		boolean isExpected = true;

		boolean isResult = response.getText().length() > 0;

		Assert.assertEquals(isExpected, isResult);
	}

	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
