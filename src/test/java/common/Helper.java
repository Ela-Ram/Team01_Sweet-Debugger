package common;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class Helper {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor jsExecutor;

	public Helper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.jsExecutor = (JavascriptExecutor) driver;
	}

	public void waitForTitle(String expectedTitle) {
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	}

	public WebElement waitForVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	public WebElement waitForVisibleElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllVisibleElements(List<WebElement> elements) {
		for (WebElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public Boolean waitForInVisibilityElement(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Checks if the scenario is tagged with a specific tag
	public static boolean isScenarioTaggedWith(Scenario scenario, String tag) {
		return scenario.getSourceTagNames().contains(tag);
	}

	// Java Streams- Get all visible texts from a list of WebElements
	public List<String> getTexts(List<WebElement> elements) {
		return elements.stream().map(WebElement::getText).map(String::trim).filter(text -> !text.isEmpty())
				.collect(Collectors.toList());
	}

	public boolean checkElementDisplayed(WebElement element) {

		try {
			element = waitForVisibleElement(element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isTextEqual(WebElement element, String value) {
		if (element.getText().equalsIgnoreCase(value)) {
			LoggerLoad.info(element.getText());
			return true;
		} else {
			return false;
		}
	}

	public WebElement waitForClickableWebElement(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}