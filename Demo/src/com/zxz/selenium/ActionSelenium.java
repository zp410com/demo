package com.zxz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//保存cookie用来跳过验证码
public class ActionSelenium {
	public WebDriver driver;
	String url = "http://192.168.10.171/iart-censor/index.html";

	public void InitDriver() {
		driver = new ChromeDriver();
		driver.get(url);
		Cookie c1 = new Cookie("PLAY_SESSION",
				"a8b4f3f7e7fb109e98e587d15d73f8bb9f234827-_user_session=5e0f58157e71366a1746cd9d277fadc2"); // 保存cookie
		driver.manage().addCookie(c1);
		driver.navigate().refresh();  //刷新
	}
	
	public void inputBox() {
		String attr = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div/input")).getAttribute("placeholder");//获取属性
//		System.out.println(attr);
	}

	public static void main(String[] args) {
		ActionSelenium actionSelenium = new ActionSelenium();
		actionSelenium.InitDriver();
		actionSelenium.inputBox();
	}

}
