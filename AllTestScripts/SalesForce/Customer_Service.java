package week4.day8;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Customer_Service {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		
		// Switching to Main Window
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://login.salesforce.com/");
		
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		//SwitchingWindow
		driver.findElement(By.xpath("//span[text()='Learn More']//parent::button")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> list1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list1.get(2));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Clilck on Products and Mousehover on Service 
		Shadow shadow = new Shadow(driver);
		Actions action = new Actions (driver);
		
		shadow.findElementByXPath("//span[text()='Products']").click();
		
		WebElement service = shadow.findElementByXPath("//div[@id='l1-0-0']/div[1]/div[1]/ul/li[3]/hgf-button/div/span[2]");
		action.moveToElement(service).perform();
		
		//Click on Customer Services
		WebElement customer = shadow.findElementByXPath("//a[text()='Customer Service']");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", customer);
		
		//Get the names Of Services Available 
		List<WebElement> list_service = driver.findElements(By.xpath("//a[@class='page-list-item ']"));
		System.out.println("List of Service Available : ");
		System.out.println("-------------------------------------------");
		for(WebElement services : list_service)
		{
			System.out.println(services.getText());
		}
		
		//Verify the title
		String title = driver.getTitle();
		if(title.contains("Customer Service"))
			System.out.println("Title verified...");
		else
			System.out.println("Title Not verified...");
		
		System.out.println("=====================");
		System.out.println("All Test Passed...");
		System.out.println("=====================");
		
		driver.quit();

	}

}
