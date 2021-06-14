package com.atos.SeleniumDemo1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBasic {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver.exe");
		
		WebDriver wd=null;
		wd=new ChromeDriver();
//browsser commands
		//	wd.get("https://www.google.com");
		//	Thread.sleep(3000);
	/*		wd.get("https://www.atos.net");
		//	System.out.println(wd.getPageSource());
			System.out.println(wd.getTitle().equals("Google"));
			System.out.println(wd.getCurrentUrl());
			wd.get(wd.getCurrentUrl()+"en/portfolio");
			
			Thread.sleep(2000);
			wd.close();
			//wd.quit();*/
//navigation commands
		/*
			Navigation nav=wd.navigate();
			wd.get("https://www.google.com");
			Thread.sleep(2000);
			nav.to("https://www.atos.net");
			Thread.sleep(2000);
			nav.back();
			Thread.sleep(2000);
			nav.forward();
			Thread.sleep(2000);
			nav.refresh();
			Thread.sleep(2000);
			nav.refresh();
			Thread.sleep(2000);
			nav.refresh();*/
//webelement
		wd.get("C:\\Users\\kathi\\Documents\\test1.html");
		WebElement txt1=wd.findElement(By.id("name"));
			System.out.println(txt1.getAttribute("value"));
			///html/body/input[2]
			WebElement txt2=wd.findElement(By.xpath("//*[@id='pass']"));
			System.out.println(txt2.getAttribute("disabled"));
			WebElement txt3=wd.findElement(By.className("city"));
			System.out.println(txt3.getAttribute("value"));
			txt3.clear();
			txt3.sendKeys("new value");
			WebElement txt4=wd.findElement(By.cssSelector(".pin"));
			System.out.println(txt4.getAttribute("value"));
			WebElement txt5=wd.findElement(By.cssSelector("#pin"));
			System.out.println(txt5.getAttribute("value"));
			
			WebElement divpara=wd.findElement(By.cssSelector("div>p"));
			//System.out.println(divpara.getText());//gets the inner text value of html element
			
			List<WebElement> divParas=wd.findElements(By.cssSelector("div>p"));
			for(WebElement l:divParas)//gets the inner text value of html element
				System.out.println(l.getText());
			
			WebElement link1=wd.findElement(By.linkText("login"));
			System.out.println(link1.getTagName());
			WebElement link2=wd.findElement(By.linkText("register"));
			System.out.println(link2.getTagName());
	//get the size and location of web emlement
			
			WebElement txt6=wd.findElement(By.id("name"));
			Point p=txt6.getLocation();
			System.out.println("X axis val is : "+p.getX());
			System.out.println("Y axis val is : "+p.getY());
			WebElement txt7=wd.findElement(By.id("pass"));
			Point p1=txt7.getLocation();
			System.out.println("X axis val is : "+p1.getX());
			System.out.println("Y axis val is : "+p1.getY());
			
			Dimension d=txt6.getSize();
			System.out.println("height "+d.getHeight());
			System.out.println("width "+d.getWidth());
			
			//
			WebElement drop=wd.findElement(By.id("course"));
			Select sel=new Select(drop);
			System.out.println("is it multiple value selectable ? "+sel.isMultiple());
			sel.selectByIndex(2);
			Thread.sleep(2000);
			sel.selectByIndex(1);
			Thread.sleep(2000);
			sel.selectByValue("java");
			Thread.sleep(2000);
					
			System.out.println("deselect");
			sel.deselectByIndex(2);
			sel.deselectByIndex(1);
			wd.get("https://ultimateqa.com/automation");
			WebElement link=wd.findElement(By.xpath("//*[@id='post-507']/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/ul/li[1]/a"));
			
			link.click();
			Thread.sleep(2000);
	}

}
