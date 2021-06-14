package com.atos.SeleniumDemo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttendanceMarker {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");

		WebDriver wd = null;
		wd = new ChromeDriver();
		wd.get("https://x0.myatos-syntel.net/FrmEmployeeDashboard.aspx");
		wd.findElement(By.xpath("//*[@id='formTotp']/button")).click();
		wd.findElement(By.name("com.siemens.dxa.applications.web.authn.challenging.username")).sendKeys("a785230");
		wd.findElement(By.name("com.siemens.dxa.applications.web.authn.challenging.response")).sendKeys("June9090");
		wd.findElement(By.name("com.siemens.dxa.applications.web.authn.challenging.response2")).sendKeys("");
		wd.findElement(By.xpath("//*[@id='dataForm']/fieldset/input[9]")).click();
		wd.findElement(By.xpath("/html/body/form/div[6]/div[4]/div/section/div[1]/div[3]/div/div[2]/div[2]/div[3]"))
				.click();
		// wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String link = wd.findElement(By.xpath("//*[@id='ContentPlaceHolder1_competencyMenu']/center/a[3]"))
				.getAttribute("href");
		wd.navigate().to(link);

		// wd.findElement(By.xpath("//*[@id='ContentPlaceHolder1_competencyMenu']/center/a[3]")).click();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.findElement(By.id("surjSubTabBar-1")).click();
		wd.findElement(By.id("__filter1")).click();
		// *[@id="__item1-__clone9-content"]
		// wd.findElement(By.xpath("//*[@id='__item1-__content']")).click();
		wd.navigate().to(
				"https://atos.plateau.com/learning/ui/instructor/pages/instructor_home.jsp?fromSF=Y#/ScheduleOffering/160125/item&itemTitle=Jenkins%2520CI%2520Tool&scheduleStatus=PAST");
		wd.findElement(By.id("__button4-__xmlview2--scheduleOfferingTable-0")).click();

		File file = new File("data.xlsx");

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sh1 = wb.getSheet("Sheet1");

		int rowCount = sh1.getLastRowNum() - sh1.getFirstRowNum();
		System.out.println("row count in excel is"+rowCount);
		for (int i = 0; i < rowCount + 1; i++) {

			Row row = sh1.getRow(i);

			// Create a loop to print cell values in a row

			out:
			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console

				// System.out.print(row.getCell(j).getStringCellValue()+"|| ");
				String rowName = row.getCell(j).getStringCellValue();
				System.out.println("in row "+rowName);
				//*[@id="__box2-__panel0-1-CB"]
				List<WebElement> chks = wd.findElements(By.xpath("//input[starts-with(@type,'CheckBox')]"));//wd.findElements(By.tagName("intput[type='CheckBox']"));
				int count = chks.size() - 1;
				System.out.println("no of check box: "+chks);
				for (int index = 0; index <= count; index++) {
					System.out.println("count -for");
					String person = "//*[@id='__box2-__panel0-" + index + "']";
					WebElement chkbox = wd.findElement(By.xpath(person));
					String name = chkbox.getAttribute("title");
					String arr[]=name.split("  ");
					String concatName="";
					
					for(String a:arr){
					concatName=concatName+" "+a;	
					}
					System.out.println("after space removal "+concatName.trim());
					if (concatName.equals(rowName)) {
						System.out.println("matched cell " + rowName + " web " + concatName);
						continue out;
					} else {
						System.out.println("not matched  web" + concatName + " cell " + rowName);
					}
					System.out.println("inner-loop over");
				}
				System.out.println("row-loop over");
			}

			System.out.println("column-loop over");
		}

	}
}
