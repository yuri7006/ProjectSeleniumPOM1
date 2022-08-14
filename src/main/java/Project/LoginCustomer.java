package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LoginCustomer {
    WebDriver driver;

    public LoginCustomer(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        this.driver= new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }
    public String openSite(String url){
        this.driver.get(url);
        return this.driver.getCurrentUrl();

    }
    public void customerLogin() {
        WebElement customerLogin = this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(1) > button"));
        customerLogin.sendKeys(Keys.ENTER);;
    }
    public void userSelect(){
        WebElement user = driver.findElement(By.name("userSelect"));
        user.sendKeys("Albus Dumbledore");
        user.click();
        WebElement loginBtn = driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > form > button"));
        loginBtn.click();
    }
    public  String deposit() throws InterruptedException {
        WebElement clickdeposit=this.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
        clickdeposit.click();
        sleep(2000);
        WebElement amountDeposited=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > div > input"));
        amountDeposited.sendKeys("1000");
        sleep(3000);
        WebElement depositBtn=this.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        depositBtn.click();
        WebElement login1000=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(3) > strong:nth-child(2)"));
        return login1000.getText();
    }

    public String withdrawl () throws InterruptedException {
        WebElement clickWithdrawl = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]"));
        clickWithdrawl.click();
        sleep(3000);

        WebElement amountToBeWithdrawn  = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        amountToBeWithdrawn.sendKeys("250");

        Thread.sleep(3000);
        WebElement btn=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        btn.click();
        WebElement checkBalance=this.driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(3) > strong:nth-child(2)"));
        return checkBalance.getText();

    }
       public void quit(){
        this.driver.quit();
       }


   }





