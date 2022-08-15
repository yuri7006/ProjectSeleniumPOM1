package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

//data
public class Manager {
    WebDriver driver;
//const
    public Manager(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        this.driver= new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }
    //func
    public String openSite(String url){
       this.driver.get(url);
       return this.driver.getCurrentUrl();
    }
    public String loginManager() throws InterruptedException {
    WebElement enterManagerLogin=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button"));
    enterManagerLogin.click();

    WebElement enterAddCustomer=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(1)"));
            enterAddCustomer.click();

    WebElement firstName=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input"));
            firstName.sendKeys("Bruce");
    WebElement lastName=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input"));
            lastName.sendKeys("Lee");
    WebElement postCode=driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input"));
            postCode.sendKeys("123456");

    WebElement add =this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button"));
           add.click();
        Thread.sleep(7000);
    WebElement customer=this.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
        customer.sendKeys(Keys.ENTER);
        WebElement search=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > form > div > div > input"));
        search.sendKeys("Bruce");
        WebElement checkSeatch=this.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]"));
        return checkSeatch.getText();}
    public void quit(){
        this.driver.quit();}

    }







