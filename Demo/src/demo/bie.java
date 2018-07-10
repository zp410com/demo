package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;


public class bie {

	public static void main(String[] args) {
		 WebDriver driver;
		 
	       String url ="http://192.168.10.171/iart-censor/index.html";
	        driver = new ChromeDriver(); 
	        driver.get(url);
	        Cookie c1 = new Cookie("PLAY_SESSION","a8b4f3f7e7fb109e98e587d15d73f8bb9f234827-_user_session=5e0f58157e71366a1746cd9d277fadc2");  //保存cookie  
	        driver.manage().addCookie(c1);
	        
//	        System.out.println(driver.manage().getCookies());

			driver.navigate().refresh();
			
//			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/ul/li[1]/a")).click();
	        
	        

	}

}
