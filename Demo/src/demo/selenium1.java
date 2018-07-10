package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium1 {

	public static void main(String[] args) {
		WebDriver driver;
//	       String url1 ="https://www.imooc.com/user/newlogin/from_url";
		String url2 = "https://www.imooc.com/";
		driver = new ChromeDriver();
		driver.get(url2);
//	        driver.manage().window().maximize();   //窗口最大化

//	        driver.findElement(By.id("auto-signin")).click();
//	        driver.findElement(By.linkText("立即注册")).click();
//	        driver.findElement(By.partialLinkText("直接")).click();  //partialLinkText获取部分字段
//	        driver.findElement(By.tagName("input")).sendKeys("18844996590");
//	        driver.findElement(By.name("password")).sendKeys("19951108ZXZzxz");
//	        driver.findElement(By.className("moco-btn-lg")).click();  //登陆

		driver.findElement(By.xpath("//*[@id=\"nav\"]/div[3]/div[2]/input[1]")).sendKeys("java");

		driver.findElement(By.xpath("//*[@id=\"nav\"]/div[3]/div[3]")).click();
		WebElement element = driver.findElement(By.className("nav-item"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
//	        driver.manage().window().maximize();   //窗口最大化

	}

}
