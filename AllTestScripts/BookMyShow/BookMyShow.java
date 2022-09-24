package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://in.bookmyshow.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		//Entering & Loading City
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for')]")).sendKeys("Hyderabad",Keys.ENTER);
		
		//Confirm City Loaded
		String link = driver.getCurrentUrl();
		
		if(link.contains("hyderabad"))
			System.out.println("Correct City Loaded!!");
		else
			System.out.println("City Not Loaded");
		
		//Enter Movie name
		driver.findElement(By.xpath("//span[contains(text(),'Search for Movies')]")).click();
		

		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for Movies')]")).sendKeys("sita");
		driver.findElement(By.xpath("//div[@class='sc-fQkuQJ hqIzUw']/span")).click();
		
		//ClickBook Tickets
		driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		Thread.sleep(5000);
		
		//Closing PopUp
		driver.findElement(By.xpath("//button[text()='Not Now']")).click();
		
		//Print First Theater Name
		String theater = driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]")).getText();
		System.out.println("Theater Name : "+theater);
		
		//Clicking Info
		driver.findElement(By.xpath("(//div[text()='INFO'])[1]")).click();
		
		//Checking Parking Facility
		String facility = driver.findElement(By.xpath("//div[contains(text(),'Parking')]")).getText();
		
		if(facility.contains("Parking"))
			System.out.println("Parking Facility Available");
		else 
			System.out.println("No Parking Facility Avalible");
		
		//Closing the Popup
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		Thread.sleep(1000);
		
		//Selecting Available Time
		driver.findElement(By.xpath("//div[contains(text(),'10:40')]")).click();
		Thread.sleep(1000);
		
		//Clicking Accept
		driver.findElement(By.id("btnPopupAccept")).click();
		Thread.sleep(1000);
		
		//Selecting Seat
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("proceed-Qty")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='B_9_014']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@id='btnSTotal_reserve'])[1]")).click();
		
		

	}

}
