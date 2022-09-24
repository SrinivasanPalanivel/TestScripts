package week4.day7;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkFrame {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		
		// Opening Web Browser using Driver
		
		EdgeDriver driver = new EdgeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		//Navigate to frame
		driver.switchTo().frame("iframeResult");
		
		//Click Try it
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Handle Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Print Text
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		
		//Back to default frame
		driver.switchTo().defaultContent();
		

	}

}
