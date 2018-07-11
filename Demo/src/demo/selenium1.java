package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium1 {
	WebDriver driver;

	public void init() {
		driver = new ChromeDriver();
		String url1 = "https://www.imooc.com/user/newlogin/from_url";
		driver.get(url1);
	}

	// 单选框
	public void initLogin() {
		driver.findElement(By.tagName("input")).sendKeys("18844996590");
		driver.findElement(By.name("password")).sendKeys("19951108ZXZzxz");
		driver.findElement(By.className("moco-btn-lg")).click(); // 登陆
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void radioBox() {
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.xpath("//*[@id=\"setting-profile\"]/div[2]/a")).click();
	}

	public static void main(String[] args) {

		selenium1 sele = new selenium1();
		sele.init();
		sele.initLogin();
		sele.radioBox();

	}

}
