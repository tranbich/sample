package Login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
/**
 * @author Emerald
 *
 */

public class First_login {

	private static final String WEB_DRIVER_CHROME = "webdriver.chrome.driver";
	private static final String PATH_SELENIUM = "F://Selenium//chromedriver.exe";
	private static final String URL = "https://221616.com/connect";

	private WebDriver driver;

	private WebElement familyName;
	private WebElement sureName;
	private WebElement email;
	private WebElement pwd;
	private WebElement loginBtn;

	@BeforeTest
	public void setup() {
		System.setProperty(WEB_DRIVER_CHROME, PATH_SELENIUM);

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		familyName = driver.findElement(By.xpath("//*[@id=\"KanjiSei\"]"));
		sureName = driver.findElement(By.xpath("//*[@id=\"KanjiMei\"]"));
		email = driver.findElement(By.xpath("//*[@id=\"Mail\"]"));
		pwd = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		loginBtn = driver.findElement(By.xpath("//*[@id=\"CP1011Login\"]/input[5]"));
	}

	// all fields are correctly inputed
	@Test(priority = 2)
	public void verifyAllFieldsSuccess() throws InterruptedException {
		familyName.sendKeys("テスト");
		sureName.sendKeys("ビック");
		email.sendKeys("bich.ttn+04@glv.co.jp");
		pwd.sendKeys("123456");

		loginBtn.click();
		Thread.sleep(10);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CM1011_submit")));

		String msg = messageElement.getText();

		String Sucmsg = "ご登録ありがとうございます！";
		
		Assert.assertTrue(msg.contains(Sucmsg));
		
//		if (msg.contains(Sucmsg)) {
//
//			System.out.println("Login successfully!!! Congratulation!!!");
//			System.out.println("message is: " + msg);
//		} else {
//			System.out.println("system failed!");
//		}
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void verifyAllFieldsError() throws InterruptedException {
		familyName.sendKeys("");
		sureName.sendKeys("");
		email.sendKeys("");
		pwd.sendKeys("");
		loginBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirm-modal")));
		wait.withTimeout(5, TimeUnit.MINUTES);

		String msg = messageElement.getText();

		String Failmsg1 = "姓をご入力ください";
		String Failmsg2 = "名をご入力ください";
		String Failmsg3 = "メルアドをご入力ください";
		String Failmsg4 = "パスワードをご入力ください";

		boolean result = false;
		if (!msg.contains(Failmsg1) || !msg.contains(Failmsg2) || !msg.contains(Failmsg3) || !msg.contains(Failmsg4)) {
			System.out.println("system failed!");
			result = false;
		} else {
			System.out.println("Login failed! please input your name and email password!");
			System.out.println("msg error:" + msg);
			result = true;
		}
		
		Assert.assertEquals(result, true);

		Thread.sleep(30);
		driver.findElement(By.id("confirm-modal"));
		driver.findElement(By.id("modalClose")).click();

	}

	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(20);
		driver.quit();
	}

}
