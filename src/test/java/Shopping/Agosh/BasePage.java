package Shopping.Agosh;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	static WebDriver driver;
	Common common = new Common(driver);
	DateFormat dateFormat;

	/**
	 * Take a ScreenShot
	 * 
	 * @throws IOException
	 */

	protected WebDriver getDriver() {

		if (driver == null) {
//           String chromeDriverPath = "/usr/bin/chromedriver";
//           String chromeDriverPath = "C:\\Users\\QA\\Downloads\\chromedriver_win32\\chromedriver.exe";
			String chromeDriverPath = "/Users/mac/Downloads/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--start-maximized");
//            options.addArguments("--headless");
			driver = new ChromeDriver(options);
			// Resize current window to the set dimension
		}
		return driver;
	}

	public void gotoURL(String url) {
		getDriver().get(url);
	}

	public void close() {
		getDriver().quit();
		driver = null;
	}

	public void enterURL() {
		gotoURL("https://www.agosh.com/home");
		System.out.println("Step 01 :: Open Url");
		common.log("Step 01 :: Open Url");
	}

	public void Take_ScreenShot() throws IOException {
		String destDir = "screenshots";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";
		FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	}

	public void verify_loing_details_of_buyer() throws InterruptedException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		common.pause(40);

		driver.findElement(By.xpath("//html/body/app-root/app-home/app-headerwithoutlogin/nav/a")).isDisplayed();
		System.out.println("Step 02 :: Verify Agosh Page Open Successfully");
		common.log("Step 02 :: Verify Agosh Page Open Successfully");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/a[3]")).click();
		System.out.println("Step 03 :: Click on Login Button");
		common.log("Step 03 :: Click on Login Button");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div[1]/div/input"))
				.sendKeys("buyer01@mailinator.com");
		System.out.println("Step 04 :: Enter Buyer Email Address");
		common.log("Step 04 :: Enter Buyer Email Address");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Qa@12345");
		System.out.println("Step 05 :: Enter Buyer Password");
		common.log("Step 05 :: Enter Buyer Password");
		common.pause(10);

		driver.findElement(
				By.xpath("//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div[5]/a"))
				.click();
		System.out.println("Step 06 :: Click on Login Button");
		common.log("Step 06 :: Click on Login Button");
		common.pause(20);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div[2]/span")).isDisplayed();
		System.out.println("Step 07 :: Verify Buyer Login Successfully!!!! ");
		common.log("Step 07 :: Verify Buyer Login Successfully!!!! ");
		common.pause(20);
	}

	public void Verify_Login_Details_of_seller() throws InterruptedException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		common.pause(40);

		driver.findElement(By.xpath("//html/body/app-root/app-home/app-headerwithoutlogin/nav/a")).isDisplayed();
		System.out.println("Step 02 :: Verify Agosh Page Open Successfully");
		common.log("Step 02 :: Verify Agosh Page Open Successfully");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/a[3]")).click();
		System.out.println("Step 03 :: Click on Login Button");
		common.log("Step 03 :: Click on Login Button");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div[1]/div/input"))
				.sendKeys("seller01@mailinator.com");
		System.out.println("Step 04 :: Enter Seller Email Address");
		common.log("Step 04 :: Enter Seller Email Address");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Qa@12345");
		System.out.println("Step 05 :: Enter Seller Password");
		common.log("Step 05 :: Enter Seller Password");
		common.pause(10);

		driver.findElement(
				By.xpath("//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div[5]/a"))
				.click();
		System.out.println("Step 06 :: Click on Login Button");
		common.log("Step 06 :: Click on Login Button");
		common.pause(20);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div[2]/span")).isDisplayed();
		System.out.println("Step 07 :: Verify Seller Login Successfully!!!! ");
		common.log("Step 07 :: Verify Seller Login Successfully!!!! ");
		common.pause(20);
	}

	public void Verify_to_Register_New_Account_for_Buyer() throws InterruptedException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		common.pause(40);

		driver.findElement(By.xpath("//html/body/app-root/app-home/app-headerwithoutlogin/nav/a")).isDisplayed();
		System.out.println("Step 02 :: Verify Agosh Page Open Successfully");
		common.log("Step 02 :: Verify Agosh Page Open Successfully");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/a[3]")).click();
		System.out.println("Step 03 :: Click on Login Button");
		common.log("Step 03 :: Click on Login Button");
		common.pause(10);

		driver.findElement(By
				.xpath("//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div[7]/p/a"))
				.click();
		System.out.println("Step 04 :: Click on Register here text");
		common.log("Step 04 :: Click on Register here text");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/div[1]/div/label[1]/span"))
				.click();
		System.out.println("Step 05 :: Select Buyer Button");
		common.log("Step 05 :: Select Buyer Button");
		common.pause(10);

		driver.findElement(By
				.xpath("//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/div[2]/div[1]/a"))
				.click();
		System.out.println("Step 06 :: Click on Next Button");
		common.log("Step 06 :: Click on Next Button");
		common.pause(10);

		Random random_number = new Random();
		int number_one = random_number.nextInt(500);
		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/form/div/div[1]/div/input"))
				.sendKeys("buyer" + number_one + "@mailinator.com");
		System.out.println("Step 07 :: Enter Email Address");
		common.log("Step 07 :: Enter Email Address");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/form/div/div[2]/div/input"))
				.sendKeys("Qa Tester");
		System.out.println("Step 08 :: Enter Full Name");
		common.log("Step 08 :: Enter Full Name");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/form/div/div[3]/div/input"))
				.sendKeys("Qa@12345");
		System.out.println("Step 09 :: Enter Password");
		common.log("Step 09 :: Enter Password");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/form/div/div[4]/div/input"))
				.sendKeys("Qa@12345");
		System.out.println("Step 10 :: Enter Confirm Password");
		common.log("Step 10 :: Enter Confirm Password");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
		System.out.println("Step 11 :: Select Checkbox of Terms & Condition");
		common.log("Step 11 :: Select Checkbox of Terms & Condition");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/form/div/div[6]/a[1]"))
				.click();
		System.out.println("Step 12 :: Click on Register Button");
		common.log("Step 12 :: Click on Register Button");
		common.pause(20);

		System.out.println("Step 13 :: Buyer Account Successfully Created!!!! ");
		common.log("Step 13 :: Buyer Account Successfully Created!!!! ");
		common.pause(10);
	}

	public void Verify_to_Register_New_Account_for_Seller() throws InterruptedException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		common.pause(40);

		driver.findElement(By.xpath("//html/body/app-root/app-home/app-headerwithoutlogin/nav/a")).isDisplayed();
		System.out.println("Step 02 :: Verify Agosh Page Open Successfully");
		common.log("Step 02 :: Verify Agosh Page Open Successfully");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/a[3]")).click();
		System.out.println("Step 03 :: Click on Login Button");
		common.log("Step 03 :: Click on Login Button");
		common.pause(10);

		driver.findElement(By
				.xpath("//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div[7]/p/a"))
				.click();
		System.out.println("Step 04 :: Click on Register here text");
		common.log("Step 04 :: Click on Register here text");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/div[1]/div/label[2]/span"))
				.click();
		System.out.println("Step 05 :: Select Seller Option");
		common.log("Step 05 :: Select Seller Option");
		common.pause(10);

		driver.findElement(By
				.xpath("//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/div/div[2]/div[1]/a"))
				.click();
		System.out.println("Step 06 :: Click on Next Button");
		common.log("Step 06 :: Click on Next Button");
		common.pause(10);

		Random random_number = new Random();
		int number_one = random_number.nextInt(500);
		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div[2]/div[1]/div/input"))
				.sendKeys("seller" + number_one + "@mailinator.com");
		System.out.println("Step 07 :: Enter Email Address");
		common.log("Step 07 :: Enter Email Address");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div[2]/div[2]/div/input"))
				.sendKeys("Seller Tester");
		System.out.println("Step 08 :: Enter Full Name");
		common.log("Step 08 :: Enter Full Name");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div[2]/div[3]/div/input"))
				.sendKeys("Qa@12345");
		System.out.println("Step 09 :: Enter Password");
		common.log("Step 09 :: Enter Password");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div[2]/div[4]/div/input"))
				.sendKeys("Qa@12345");
		System.out.println("Step 10 :: Enter Confirm Password");
		common.log("Step 10 :: Enter Confirm Password");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div[2]/div[5]/a[1]"))
				.click();
		System.out.println("Step 11 :: Click on Next Button");
		common.log("Step 11 :: Click on Next Button");
		common.pause(20);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[1]/div/input"))
				.sendKeys("New Mobile Store");
		System.out.println("Step 12 :: Enter Business Name");
		common.log("Step 12 :: Enter Business Name");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[3]/div/input"))
				.sendKeys("9695712" + random_number);
		System.out.println("Step 13 :: Enter Business Licence Number");
		common.log("Step 13 :: Enter Business Licence Number");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[9]/a[1]"))
				.click();
		System.out.println("Step 15 :: Click on Next Button");
		common.log("Step 15 :: Click on Next Button");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[1]/div/input"))
				.sendKeys("3584551");
		System.out.println("Step 16 :: Enter Postal Code");
		common.log("Step 16 :: Enter Postal Code");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[2]/div/input"))
				.sendKeys("A25");
		System.out.println("Step 17 :: Enter building Number");
		common.log("Step 17 :: Enter building Number");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[3]/div/input"))
				.sendKeys("New testing area");
		System.out.println("Step 17 :: Enter Area");
		common.log("Step 17 :: Enter Area");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[4]/div/input"))
				.sendKeys("New landmark");
		System.out.println("Step 18 :: Enter LandMark");
		common.log("Step 18 :: Enter LandMark");
		common.pause(10);

		Select select_country = new Select(driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[5]/div/select")));
		select_country.selectByVisibleText("Select Country");
		select_country.selectByIndex(101);
		System.out.println("Step 19 :: Select Country");
		common.log("Step 19 :: Select Country");
		common.pause(10);

		Select select_state = new Select(driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[6]/div/select")));
		select_state.selectByVisibleText("Select State");
		select_state.selectByIndex(21);
		System.out.println("Step 20 :: Select State");
		common.log("Step 20 :: Select State");
		common.pause(10);

		Select select_city = new Select(driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[7]/div/select")));
		select_city.selectByVisibleText("Select City");
		select_city.selectByIndex(11);
		System.out.println("Step 21 :: Select City");
		common.log("Step 21 :: Select City");
		common.pause(10);

		driver.findElement(By.xpath(
				"//html/body/ngb-modal-window/div/div/div/app-login/div/div[2]/div/div[2]/form/div/div/div/div[9]/a[1]"))
				.click();
		System.out.println("Step 22 :: Click on Register Button");
		common.log("Step 22 :: Click on Register Button");
		common.pause(20);

		System.out.println("Step 23 :: Seller Account Successfully Created!!!! ");
		common.log("Step 23 :: Seller Account Successfully Created!!!! ");
		common.pause(10);
	}

	public void Verify_to_Logout_of_Buyer() throws InterruptedException, IOException {

		verify_loing_details_of_buyer();

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div[2]/span")).click();
		System.out.println("Step 08 :: Click on Username");
		common.log("Step 08 :: Click on Username");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div[2]/ul/li[2]/a")).click();
		System.out.println("Step 09 :: Click on Logout Text");
		common.log("Step 09 :: Click on Logout Text");
		common.pause(20);

		System.out.println("Step 10 :: Buyer User Logout Successfully!!! ");
		common.log("Step 10 :: Buyer User Logout Successfully!!! ");
		common.pause(10);
	}

	public void Verify_to_Logout_of_Seller() throws InterruptedException, IOException {

		Verify_Login_Details_of_seller();

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div[2]/span")).click();
		System.out.println("Step 08 :: Click on Username");
		common.log("Step 08 :: Click on Username");
		common.pause(10);

		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div[2]/ul/li[2]/a")).click();
		System.out.println("Step 09 :: Click on Logout Text");
		common.log("Step 09 :: Click on Logout Text");
		common.pause(20);

		System.out.println("Step 10 :: Seller User Logout Successfully!!! ");
		common.log("Step 10 :: Seller User Logout Successfully!!! ");
		common.pause(10);
	}

}
