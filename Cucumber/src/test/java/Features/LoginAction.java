package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;


public class LoginAction {
    WebDriver driver;

    @Given("^User is on Home Page$")
    public void user_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("^User navigate to Login Page$")
    public void user_navigate_to_login_page() {
        // No need to navigate again, we are already on the login page
    }

    @Then("^User enters \"([^\"]*)\" and \"([^\"]*)\" keeping case as \"([^\"]*)\"$")
    public void user_enters_credentials(String username, String password, String caseType) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @Then("^User should get logged in if \"([^\"]*)\" is Valid$")
    public void user_should_get_logged_in(String caseType) {
        
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            
            String currentUrl = driver.getCurrentUrl();
            if (caseType.equals("Valid") && currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("Login successful");
            } else {
            	 System.out.println("Login failed.");
            }
        }
    

    @Then("^Message displayed Login Successfully if \"([^\"]*)\" is Valid$")
    public void message_displayed_login_successfully(String caseType) {
        if (caseType.equals("Valid")) {
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("Login success");
            } else {
            	 System.out.println("Login Failed");
            }
        }
    }

    @Then("^User will be asked to go back to login page if \"([^\"]*)\" is Invalid$")
    public void user_asked_to_go_back_to_login_page(String caseType) {
        if (caseType.equals("Invalid")) {
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("User was not redirected to the login page.");
            } else {
                System.out.println("User was redirected to the login page.");
            }
        }
    }

    @Then("^Provide correct credentials if \"([^\"]*)\" is Invalid$")
    public void provide_correct_credentials(String caseType) {
        if (caseType.equals("Invalid")) {
        	System.out.println("User asked to provide correct credentials");
        	driver.get("https://www.saucedemo.com/");            
        }
    }
}
