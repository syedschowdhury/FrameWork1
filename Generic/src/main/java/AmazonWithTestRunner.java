import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonWithTestRunner {

    WebDriver driver = null;
    @BeforeMethod
    public  void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\mahin\\IdeaProjects\\NewFramework\\Generic\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();




    }
    @AfterMethod
    public  void cleaning(){
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Book", Keys.ENTER);
        Thread.sleep(2000);
    }
    @Test
    public void test2(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com: online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}