import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Twitter {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zincat User\\Downloads\\selenium\\2\\chromedriver.exe");
        // change the path to your chromedriver path
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com/");
        Thread.sleep(2000);
        // Thread.sleep delays the execution speed
        String actualtitle = driver.getTitle();
        // getTitle method will return the web page title
        String expectedtitle = "Twitter. It’s what’s happening / Twitter";
        Assert.assertEquals(actualtitle,expectedtitle);
        // Assert is a TestNG annotation of verifying stuff
        System.out.println(actualtitle);
        driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/a[1]/div[1]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time before it throws a “No Such Element Exception”. The default setting is 0. Once we set the time,
        // the web driver will wait for the element for that time before throwing an exception.
        // This is important because without this step twitter login is not working
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("username");
        // add your username
        driver.findElement(By.xpath("//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password#");
        // add your password
        driver.findElement(By.cssSelector("div[role='button'] div[class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr")).sendKeys("This is an automated tweet via Selenium");
        driver.findElement(By.xpath("//span[@class='css-901oao css-16my406 css-1hf3ou5 r-poiln3 r-a023e6 r-rjixqe r-bcqeeo r-qvutc0']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'][normalize-space()='Tweet']")).click();
    }
}


