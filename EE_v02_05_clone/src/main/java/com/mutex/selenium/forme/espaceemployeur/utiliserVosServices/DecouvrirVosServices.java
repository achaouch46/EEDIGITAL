package com.mutex.selenium.forme.espaceemployeur.utiliserVosServices;

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

public class DecouvrirVosServices extends BasePage {


	@FindBy(xpath = "//a[@href='/Utiliser-vos-services/Decouvrir-vos-services']")
	WebElement DecouvrirVosServicesAffichage;
	
	private WebDriver driver;

	public DecouvrirVosServices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@Step("L'écran affiché est 'Decouvrir-vos-services'.")
	public void DecouvrirVosServicesAffichage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DecouvrirVosServicesAffichage));
	}
	
	
}
