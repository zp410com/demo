package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium1 {

	public static void main(String[] args) {
		  WebDriver driver;
	       String url ="https://www.imooc.com/user/newlogin/from_url";
	        driver = new ChromeDriver(); 
	        driver.get(url);
	        driver.manage().window().maximize();   //窗口最大化

	        driver.findElement(By.id("auto-signin")).click();
	        driver.findElement(By.linkText("立即注册")).click();
	        driver.findElement(By.partialLinkText("直接")).click();  //partialLinkText获取部分字段
	        driver.findElement(By.tagName("input")).sendKeys("18844996590");
	        driver.findElement(By.name("password")).sendKeys("19951108ZXZzxz");
	        driver.findElement(By.className("moco-btn-lg")).click();  //登陆
	        
//	        driver.manage().window().maximize();   //窗口最大化
	        
	        
	}

}
