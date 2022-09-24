package week4.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		
		EdgeDriver driver = new EdgeDriver();
		
		driver.get("https://jqueryui.com/draggable/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement findElement = driver.findElement(By.id("draggable"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDropBy(findElement, 100, 150).perform();

	}

}
