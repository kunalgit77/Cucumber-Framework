package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.crm.qa.utility.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

	 WebDriver driver;

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
	 System.setProperty("webdriver.chrome.driver","D:\\selenium 3.14\\chrome78v\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://freecrm.co.in/");
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Free CRM in the cloud software boosts sales", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.name("username")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
	 WebElement loginBtnFirst = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
	 loginBtnFirst.click();
	 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	 WebElement loginBtnSecond = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
	 loginBtnSecond.click();
	 
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("Cogmento CRM", title);
	 }
	 
	 @Then("^user moves to click contact page$")
	 public void user_moves_to_new_contact_page() {
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		
		}
	 
	 @Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname, String company){
		 WebElement clickNew = driver.findElement(By.linkText("New"));
		 Actions action = new Actions(driver);
		 action.moveToElement(clickNew).click().build().perform();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@name='first_name' and @type='text']")).sendKeys(firstname);
		 driver.findElement(By.xpath("//input[@name='last_name' and @type='text']")).sendKeys(lastname);
		 driver.findElement(By.xpath("//input[@class='search' and @type='text']")).sendKeys(company);
		 WebElement save = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		 action.moveToElement(save).click().build().perform();

	 }
	 

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
