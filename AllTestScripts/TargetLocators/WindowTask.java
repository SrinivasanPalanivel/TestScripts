package week4.day7;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTask {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://leafground.com/window.xhtml");
		
		driver.manage().window().maximize();
		
		//Opening and Confirming New Window
		driver.findElement(By.xpath("//span[text()='Open']//parent::button")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(list.get(2));
		String title = driver.getTitle();
		
		if(title.equals("Dashboard"))
			System.out.println("Windoew Switch Confirmed!!!");
		else
			System.out.println("Window Not Switched!!!");
		
		driver.switchTo().window(list.get(1));
		
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']//parent::button")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		ArrayList<String> list0 = new ArrayList<String>(windowHandles2);
		
		System.out.println("Number Opened Windows : "+windowHandles2.size());
		
		driver.switchTo().window(list0.get(1));
		
		//Close all windows except Primary
		
		driver.findElement(By.xpath("//span[text()='Close Windows']//parent::button")).click();
		
		Set<String> windowHandles3 = driver.getWindowHandles();
		
		ArrayList<String> list1 = new ArrayList<String>(windowHandles3);
		
		for(int i=2; i<list1.size(); i++)
		{
			driver.switchTo().window(list1.get(i));
			driver.close();
		}
		
		System.out.println("All Window Closed Sucessfully!!!");
		
		driver.switchTo().window(list1.get(1));
		
		//Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[contains(text(),'delay')]//parent::button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		
		Set<String> windowHandles4 = driver.getWindowHandles();
		ArrayList<String> list2 = new ArrayList<String>(windowHandles4);
		
		System.out.println("Number of Windows : "+list2.size());
		
		Thread.sleep(3000);
		
		driver.quit();
		

	}

}
