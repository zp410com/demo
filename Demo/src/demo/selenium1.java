package demo;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class selenium1 {
    WebDriver driver;
    String windowshandles;

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
        threadSleep(3000); //source tree

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
//				System.out.println("");
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


    //下拉框操作
    public void selectBox() {
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.className("pull-right")).click();
        threadSleep(1000);

        WebElement element = driver.findElement(By.id("profile")).findElement(By.id("job"));    //层级定位
        Select downList = new Select(element);

//        downList.selectByIndex(4);    //通过索引
//        downList.selectByValue("1");    //通过value
//        downList.selectByVisibleText("Web前端工程师");   //通过可见文本】

//        System.out.println(downList.isMultiple());    //判断是否为多选的下拉列表
//        downList.deselectByIndex(3);  //只能取消多选的下拉列表，单选无法去除

//        List<WebElement> list = downList.getAllSelectedOptions();  //getAllSelectedOptions针对多选列表
//        for (WebElement listIndex : list
//                ) {
//
//            System.out.println(listIndex.getText());
//
//        }
//        downList.getFirstSelectedOption().getText();    //当前选择的选项

    }

    /**
     * 鼠标事件
     */

    public void mouseAction() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[9]/div[1]/a"));

        Actions actions = new Actions(driver);
//        actions.click(element).perform();   //模拟鼠标点击

//        actions.doubleClick(element).perform(); //双击
//        threadSleep(1000);
//        actions.contextClick(element).perform();  //右击
        windowshandles = driver.getWindowHandle();  //获取当前窗口
        actions.moveToElement(element).perform();   //鼠标悬停


        //点击"区块链"
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/a[2]")).click();


    }


    /**
     * iframe切换
     */

    public void iframe(String content) {
        driver.get("https://www.imooc.com/wiki/create");
        WebElement iframeElement = driver.findElement(By.id("ueditor_0"));
        driver.switchTo().frame(iframeElement); //切换到当前iframe

        driver.findElement(By.xpath("/html/body")).sendKeys(content);   //输入内容
    }

    /**
     * 窗口切换
     */

    public void windowsHandle(){
        //获取到所有的窗口
        Set<String> handles =driver.getWindowHandles();
        for (String s: handles) {

            if (s.equals(windowshandles)){
                //等于当前窗口继续循环，否则跳出循环(等同于else)
//                continue;
            }else{
                driver.switchTo().window(s);
            }

        }
        //点击"中级"
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[2]/div/div[3]/div/ul/li[4]/a")).click();

    }

    public static void main(String[] args) {

        selenium1 sele = new selenium1();
        sele.init();


//		  sele.checkBox();

//        sele.initLogin();
//        sele.iframe("测试文本");
        sele.mouseAction();
        sele.windowsHandle();
//        sele.selectBox();
//        sele.upFile();
//		  sele.radioBox();

    }

}
