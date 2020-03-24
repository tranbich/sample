package Login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
/**
 * 
 */
/**
 * @author Emerald
 *
 */



public class Login_noname{
	
	public static void main(String[] args) throws IOException{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://221616.com/connect");
		
		//In case of all name fields blank
		
		WebElement Familyname = driver.findElement(By.xpath("//*[@id=\"KanjiSei\"]"));
		Familyname.sendKeys("");
		
		WebElement Surename = driver.findElement(By.xpath("//*[@id=\"KanjiMei\"]"));
		Surename.sendKeys("");
		
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"Mail\"]"));
		Email.sendKeys("bich.ttn+1@glv.co.jp");
		
		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		pwd.sendKeys("123456");
		
		WebElement Loginbtn = driver.findElement(By.xpath("//*[@id=\"CP1011Login\"]/input[5]"));
		Loginbtn.click();
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement messageElement = wait.until(
		           ExpectedConditions.presenceOfElementLocated(By.id("confirm-modal"))
		            );
		    
		 
		    String msg                 = messageElement.getText();
		    
//		    System.out.println(msg);
		   
		    
		    String Failmsg1 = "姓をご入力ください";
		    String Failmsg2 = "名をご入力ください"; 
		    
		    if(msg.contains(Failmsg1) && msg.contains(Failmsg2)) {
		    	
		    	System.out.println("Login failed! please input your name!");
		    	System.out.println(msg);
		    }
		   else {
		    	System.out.println("system failed!");
		    }
		
		driver.close();	
		 
		
	}
	
	
}

	