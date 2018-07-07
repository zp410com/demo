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
	        
	        
	        Cookie c1 = new Cookie("PLAY_SESSION","3b91ce4d4a87ce5de09f9a3d1aa1389827b73ec5-_user_session=90f70a85889c3a4808084d375773be07");  //保存cookie  
	        driver.manage().addCookie(c1);
	        
//	        System.out.println(driver.manage().getCookies());

			driver.navigate().refresh();
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/ul/li[1]/a")).click();
	        
	        

	}

}
