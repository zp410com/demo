package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.Select;


public class bie {
    WebDriver driver;  //初始化


    public void session() {

        String url = "http://192.168.10.171/iart-censor/index.html";
        driver = new ChromeDriver();
        driver.get(url);
        Cookie c1 = new Cookie("PLAY_SESSION", "096b72b1fd13fef6b8450ea71b598e709fb48e63-_user_session=5196518f948748452419787cbea9e1e6");  //保存cookie

        driver.manage().addCookie(c1);
        driver.navigate().refresh();

    }

    /**
     * 题库管理-新增题目
     * 登陆进去后，题库管理默认为展开幕状态
     */

    public void subject() {
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button[2]")).click();    //点击音乐
        //点击新增题目
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/ul/li[1]/ul/li[3]/a")).click();
        //点击美术
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/button[2]")).click();
        //输入题干
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/textarea"))
                .sendKeys("自动化测试题干");


        //设置选项
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/div[1]/div[1]/input"))
                .sendKeys("选项A");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/div[2]/div[1]/input"))
                .sendKeys("选项B");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/div[3]/div[1]/input"))
                .sendKeys("选项C");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/div[4]/div[1]/input"))
                .sendKeys("选项D");



        //设置正确答案
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div"))
                .click();

        //题目解析
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/textarea"))
                .sendKeys("这是个自动化测试的题目");


        //出版社
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div"))
                .click();   //点击下拉框
        driver.findElement((By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/ul/li[1]"))).click();


        //适用范围
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div"))
                .click();


        //七年级
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/ul/li[8]"))
                .click();


    }

    public static void main(String[] args) {
        bie bieDemo = new bie();
        bieDemo.session();
        bieDemo.subject();

    }

}
