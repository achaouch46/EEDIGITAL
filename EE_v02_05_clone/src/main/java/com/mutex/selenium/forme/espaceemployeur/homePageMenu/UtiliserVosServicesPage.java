package com.mutex.selenium.forme.espaceemployeur.homePageMenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mutex.selenium.Base.BasePage;
import com.mutex.selenium.constants.Constants;
import com.mutex.selenium.util.TestUtil;

import io.qameta.allure.Step;

public class UtiliserVosServicesPage extends BasePage {


	@FindBy(xpath = "//a[@href='/Utiliser-vos-services/Decouvrir-vos-services']")
	WebElement DecouvrirVosServices;
	
	private WebDriver driver;

	public UtiliserVosServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@Step("On Ouvre le Menu 'Decouvrir-vos-services'.")
	public void clickDecouvrirVosServices() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DecouvrirVosServices));
		DecouvrirVosServices.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/Utiliser-vos-services/Decouvrir-vos-services']"))));

	}
	
	
}
