package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class selenium1 {
	WebDriver driver;

	public void init() {
		driver = new ChromeDriver();
//		String url1 = "https://www.imooc.com/user/newlogin/from_url";
		String url2 = "https://www.imooc.com/";
		driver.get(url2);
	}

	// 等待
	public void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 登陆
	public void initLogin() {
		driver.findElement(By.id("js-signin-btn")).click();
		threadSleep(2000);
		driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[1]/input")).sendKeys("18844996590");
		driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[2]/input")).sendKeys("19951108ZXZzxz");
		driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input")).click();
		threadSleep(3000);

	}

	// 单选框
	public void radioBox() {
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.xpath("//*[@id=\"setting-profile\"]/div[2]/a")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"profile\"]/div[4]/div/label//input"));

		for (WebElement radio : elements) {
			boolean flag = radio.isSelected();
			if (flag == false) {
				radio.click();
				System.out.println("");
				break;
			}
			System.out.println("nnnnn");
		}
	}

	// 多选框

	public void checkBox() {
		WebElement check = driver.findElement(By.id("auto-signin"));
		boolean isSe = check.isSelected();
		check.click();
	}

	// 表单
	public void webForm() {
//		driver.findElement(By.id("id=\"signup-form\"")).submit();

	}

	// 上传文件
	public void upFile() {
		driver.get("https://www.imooc.com/user/setbindsns");
		threadSleep(5000);
		/**
		 * 执行js脚本 80-82
		 */
		String jsString = "document.getElementsByClassName('update-avator')[0].style.bottom='0'; ";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsString); 
		threadSleep(1000);	
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div[1]/div/p/a")).click();
		threadSleep(100);
//		driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div/div/div[1]/div[2]/form/a")).click();
		driver.findElement(By.id("upload")).sendKeys("/Users/zhangxianzhao/Desktop/timg.jpeg");   //选择上传路径
		driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div/div/div[2]/div/a[1]")).click();
		
	}

	public static void main(String[] args) {

		selenium1 sele = new selenium1();
		sele.init();
//		sele.checkBox();

		sele.initLogin();
		sele.upFile();
//		sele.radioBox();

	}

}
