package com.atos.SeleniumDemo1;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver.exe");
				WebDriver wd=null;
		wd=new ChromeDriver();
/*		wd.get("https://www.google.com");
		String mainWin=wd.getWindowHandle();
		System.out.println(mainWin);
		Thread.sleep(3000);
		Set<String> winList=wd.getWindowHandles();
		ArrayList<String> li=new ArrayList<String>(winList);
		System.out.println(li.get(0));
	//	if(mainWin!=li.get(1))
		wd.switchTo().window(li.get(1));
		wd.get("https://www.w3schools.com");
		*/
	/*	wd.get("https://www.google.com");
		// actions in selenium
		Actions act=new Actions(wd);
		//act.contextClick().perform();
		act.contextClick(wd.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))).perform();;
		Thread.sleep(3000);
		*/
		//2 txt boxes , write a content into one text box and copy it and paste in inot another text box -actions, Keys
		wd.get("C:\\Users\\kathi\\Documents\\test1.html");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*WebElement btn1=wd.findElement(By.id("btn"));
		btn1.click();
		Alert al=wd.switchTo().alert();
		Thread.sleep(3000);
		al.accept();*/
		/*WebElement txt1=wd.findElement(By.id("name"));
		txt1.clear();
		txt1.sendKeys("kumar");
		
*/		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(wd)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
				
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
				  public WebElement apply(WebDriver driver) {
				    return driver.findElement(By.id("foo"));
				  }
				});
				  
		
		
	}

}
