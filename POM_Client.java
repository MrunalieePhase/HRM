package HRM_Sce_2;

import org.testng.annotations.Test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;



public class POM_Client 
{
	public WebDriver driver;
	public LoginPage l1;
	public AdminPage a1;

	
  @Test
  public void testLogin_and_AdminPage() 
  {
	  l1.login("Admin", "admin123");
	  a1.menu_options();
	  a1.searchByUserName("Admin");
	  a1.searchByUserRole();
	  a1.searchByUserStatus();
  }

  

  @BeforeTest
  public void beforeTest() 
  {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  l1 = new LoginPage(driver);
	  a1 = new AdminPage(driver);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

  

}
