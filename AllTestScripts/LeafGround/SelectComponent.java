package week2.day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectComponent {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.leafground.com/select.xhtml");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		//Selecting Tool
		WebElement tool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select si = new Select(tool);
		si.selectByVisibleText("Selenium");
		
		//Selecting Country
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[1]")).click();
		driver.findElement(By.xpath("//li[text()='India']")).click();
		Thread.sleep(500);        
		
		//Selecting & Confirming the Cities Loaded
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[2]")).click();
		Thread.sleep(1000);
		List<WebElement> city = driver.findElements(By.xpath("//li[@data-label='Bengaluru' or @data-label='Chennai' or @data-label='Delhi' ]"));  
		
		if(city.size()==3)
		{
			System.out.println("All Cities Loaded Sucessfully!!");
		}
		else
		{
			System.out.println("Task Failed!!");
		}
		
		//Choosing Course
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		driver.findElement(By.xpath("//li[text()='Playwright']")).click();
		
		//Selecting Language
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[3]")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//li[text()='Tamil']")).click();
		
		//Select 'Two' 
		Thread.sleep(500);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[4]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//li[@id='j_idt87:value_1']")).click();    

		
}

}
