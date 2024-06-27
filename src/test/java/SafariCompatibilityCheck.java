
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

    public class SafariCompatibilityCheck {
        public static void main(String[] args) {
            try {
                WebDriver driver = new SafariDriver();
                driver.get("https://www.example.com");
                System.out.println("Page title is: " + driver.getTitle());
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


