package com.sqa.ala.ws;

import java.io.*;
import java.util.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.ala.helpers.*;

public class WSTest extends BasicTest {

	public WSTest() {
		super("http://william-sonoma");
	}

	@Test(enabled = false)
	public void elementsTest() {
		WebElement titleTabPath = getDriver().findElement(By.xpath("html/body/header/section[2]/section/ul/li[1]/a"));
		WebElement titleTabCSS =
				getDriver().findElement(By.cssSelector(".tab-williams-sonoma.tab-williams-sonoma_current"));
		WebElement myAccountLinkPath =
				getDriver().findElement(By.xpath("html/body/header/section[2]/section/div/div/div[1]/a"));
		WebElement myAccountLinkCSS = getDriver().findElement(By.cssSelector(".my-account.dropDown>a"));
		WebElement cartLinkPath =
				getDriver().findElement(By.xpath("html/body/header/section[2]/section/div/div/div[3]/span[1]/a/span"));
		WebElement cartLinkCSS = getDriver().findElement(By.cssSelector(".view-cart>span"));
		WebElement checkoutLinkPath =
				getDriver().findElement(By.xpath("html/body/header/section[2]/section/div/div/div[3]/span[3]/a"));
		WebElement checkoutLinkCSS = getDriver().findElement(By.cssSelector(".checkout-button>a"));
		WebElement bakewareLinkPath = getDriver().findElement(By.xpath("html/body/header/nav/ul/li[5]/a"));
		WebElement bakewareLinkCSS = getDriver().findElement(By.cssSelector(".topnav-bakeware"));
		WebElement calphalonSubLinkPath =
				getDriver().findElement(By.xpath("html/body/header/nav/ul/li[5]/div/div[2]/ul/li[5]/a"));
		WebElement calphalonSubLink = getDriver().findElement(By.cssSelector(".col.hasDivider>ul>li>a"));
		WebElement searchFieldPath = getDriver().findElement(By.xpath(".//*[@id='search-field']"));
		WebElement searchFieldCss = getDriver().findElement(By.cssSelector("#search-field"));
		WebElement searchButtonPath = getDriver().findElement(By.xpath(".//*[@id='btnSearch']"));
		WebElement searchButtonCSS = getDriver().findElement(By.cssSelector(".col.hasDivider>ul>li>a"));
	}

	@Test(enabled = false)
	public void readPropertiesTest() {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream("src/main/resources/config.properties");
			props.load(input);
		} catch (FileNotFoundException e) {
			getLog().warn("can not load config properties file because it was not found.");
		} catch (IOException e) {
			getLog().warn("can not load config properties file because it was not found.");
		}
		getLog().info("Author is " + props.getProperty("author"));
		getLog().info("URL is " + props.getProperty("server-type"));
		getLog().info("Server type is " + props.getProperty("server-type"));
		getLog().info("Server IP is " + props.getProperty("server-ip"));
		getLog().info("Port is " + props.getProperty("port"));
		getLog().info("username is " + props.getProperty("username"));
		getLog().info("password is " + props.getProperty("password"));
	}

	@Test(enabled = false)
	public void testItemPurchase() {
		deletePopupAd();
	}

	@Test(enabled = false)
	public void testLogging() {
		getLog().trace("Hello this is a trace message");
		getLog().debug("Hello this is a debug message");
		getLog().info("Hello this is an info message");
		getLog().warn("Hello this is a warn message");
		getLog().error("Hello this is an error message");
		getLog().fatal("Hello this is a fatal message");
	}

	@Test
	public void writePropertiesTest() {
		Properties props = new Properties();
		props.setProperty("test-name", "Williams Sonoma Test");
		props.setProperty("test-case", "ID101");
		props.setProperty("pass-fail", "pass");
		OutputStream output;
		try {
			output = new FileOutputStream("src/main/resources/test.properties");
			props.store(output, "Test Case Properties");
		} catch (FileNotFoundException e) {
			getLog().warn("Properties file can not access storage location ");
		} catch (IOException e) {
			getLog().warn("Properties file can not be written");
		}
	}

	private void deletePopupAd() {
		// if (AutoBasics.isElementPresent(getDriver(),
		// By.className("stickyOverlayMinimizeButton"))) {
		if (present(By.className("stickyOverlayMinimizeButton"))) {
			WebElement popup = getDriver().findElement(By.className("stickyOverlayMinimizeButton"));
			getLog().info("Clicking popup.");
			this.takeScreenshot("WS-Test-Before");
			popup.click();
		} else {
			getLog().warn("Did not find popup.");
		}
		this.takeScreenshot("WS-Test-After");
	}
}
