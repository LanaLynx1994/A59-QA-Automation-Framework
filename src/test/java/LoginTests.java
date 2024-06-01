import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {
        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    // Happy path - Login Test
    @Test
    public void loginValidEmailPassword() throws InterruptedException {


        navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        //Avatar Icon for Actual VS Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    // Not so happy Path - Negative Test case
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //Step 1
        navigateToPage();
        //Step 2
        provideEmail("invalid@testpro.io");
        //Step 3
        providePassword("nTtAZKUq");
        //Step 4
        clickSubmit();
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    // Not so Happy path - Login Test
    @Test
    public void loginWithValidEmailNoPassword() throws InterruptedException {



        //Step 1
        navigateToPage();
        //Step 2
        provideEmail("sviatlana.rysiavets@testpro.io");
        //Step 3
        clickSubmit();
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    // Happy path - Login Test
    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //Precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //Step 1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("sviatlana.rysiavets@testpro.io");
        Thread.sleep(2000);
        //Step 3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("nTtAZKUq");
        Thread.sleep(2000);
        //Step 4
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(4000);
        //Avatar Icon for Actual VS Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit browser
        driver.quit();
    }

    // Not so happy Path - Negative Test case
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        //Precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //Step 1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalid@testpro.io");
        Thread.sleep(2000);
        //Step 3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("nTtAZKUq");
        Thread.sleep(2000);
        //Step 4
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(4000);
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Quit browser
        driver.quit();

    }

    // Not so Happy path - Login Test
    @Test
    public void loginWithValidEmailNoPassword() throws InterruptedException {

        //Precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //Step 1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("sviatlana.rysiavets@testpro.io");
        Thread.sleep(2000);
        //Step 3
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(4000);
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Quit browser
        driver.quit();
    }
}


