package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HeroKuapp {
    // 1.Setup Chrome browser
    static String browser = "Chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        // 2. Multiple browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        // 3. Open URL
        driver.get(baseUrl);
        // 4. Maximize the window
        driver.manage().window().maximize();
        // 5.Timeout for hold the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // 6.Print the title of the page.
        System.out.println(driver.getTitle());
        // 7.Print the current url.
        System.out.println(driver.getCurrentUrl());
        //8.Print the page source
        System.out.println(driver.getPageSource());
        //9.Enter the email to email field
        driver.findElement(By.id("username")).sendKeys("tester");
        //10.Enter the password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //11.Click on login button
        driver.findElement(By.className("radius")).click();
        //12.Print the current url
        System.out.println(driver.getCurrentUrl());
        //13.Refresh the page
        driver.navigate().refresh();
        //14.close the browser
        driver.quit();
    }
}
