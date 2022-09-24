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

public class Architect {

	public static void main(String[] args) throws InterruptedException {
		
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
		
		//Click On Resources
		driver.findElement(By.linkText("Resources")).click();
		
		//To Access Element in Shadow Root
		Shadow shadow = new Shadow(driver);
		Actions action = new Actions(driver);
		
		shadow.findElementByXPath("//span[text()='Learning']").click();
		
		WebElement trailhead = shadow.findElementByXPath("//span[contains(text(),'Trailhead')]");
		action.moveToElement(trailhead).perform();
		Thread.sleep(2000);
		
		//Clilck on Salesforce Certifications
		
		WebElement certification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", certification);
		
		//Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[2]")).click();
		
		//Get the Text(Summary) of Salesforce Architect 
		String summary = driver.findElement(By.xpath("//div[@id='cert-site']/div[2]/div[2]/div/div[1]")).getText();
		System.out.println("Summury : "+summary);
		
		//Get the List of Salesforce Architect Certifications Available
		List <WebElement> title = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		System.out.println("List of Salesforce Architect Certifications Available : ");
		System.out.println("-------------------------------------------");
		for(WebElement card : title)
		{
			System.out.println(card.getText());
		}
		
		//Click on Application Architect 
		driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[1]")).click();
		
		//Get the List of Certifications available
		List <WebElement> title1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		System.out.println("Title of the Certifications are Below : ");
		System.out.println("-------------------------------------------");
		for(WebElement card1 : title1)
		{
			System.out.println(card1.getText());
		}
		
		System.out.println("=====================");
		System.out.println("All Test Passed...");
		System.out.println("=====================");
		
		driver.quit();

	}

}
