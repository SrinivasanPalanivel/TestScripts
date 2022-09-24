package week4.day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkAlerts {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		
		// Opening Web Browser using Driver
		
		EdgeDriver driver = new EdgeDriver();
		
		driver.get("https://www.leafground.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();
		
		driver.findElement(By.xpath("//span[text()='Alert']/ancestor::a")).click();
		
		WebElement prompt = driver.findElement(By.xpath("(//span[text()='Show'])[5]"));
		prompt.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		
		alert.dismiss();
		

	}

}
