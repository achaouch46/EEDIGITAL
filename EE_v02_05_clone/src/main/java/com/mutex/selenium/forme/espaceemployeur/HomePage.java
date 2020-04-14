package com.mutex.selenium.forme.espaceemployeur;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mutex.selenium.Base.BasePage;
import com.mutex.selenium.constants.Constants;
import com.mutex.selenium.util.TestUtil;

import io.qameta.allure.Step;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[@href='/Suivre-vos-salaries']")
	WebElement SuivreVosSalariers;

	@FindBy(xpath = "//ul[@id='sous-menu']/li[1]/a")
	WebElement ListeDuPersonnelCouvert;
	
	@FindBy(xpath = "//a[@href='/Consulter-vos-informations']")
	WebElement ConsulterVosInformations;
	
	@FindBy(xpath = "//a[@href='/Consulter-vos-informations/Documents-contractuels']")
	WebElement DocumentsContractuels;
	
	@FindBy(xpath = "//a[@href='/Utiliser-vos-services']")
	WebElement UtiliserVosServices;
	
	@FindBy(xpath = "//a[@href='/Utiliser-vos-services/Decouvrir-vos-services']")
	WebElement DecouvrirVosServices;
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("On Ouvre la page :'Espace employeur'")
	public String getEspaceEmployeuPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Espace employeur"));
		return driver.getTitle();
	}

	@Step("On Ouvre le Menu 'Suivre-vos-salarie'.")
	public void clickSuivreVosSalaries() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SuivreVosSalariers));
		SuivreVosSalariers.click();
		wait.until(ExpectedConditions.visibilityOf(ListeDuPersonnelCouvert));
	}
	
	@Step("On Ouvre le Menu 'Consulter-vos-informations'.")
	public void clickConsulterVosInformations() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ConsulterVosInformations));
		ConsulterVosInformations.click();
		wait.until(ExpectedConditions.visibilityOf(DocumentsContractuels));
	}

	@Step("On Ouvre le Menu 'Utiliser-vos-Services'.")
	public void clickUtiliserVosServices() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(UtiliserVosServices));
		UtiliserVosServices.click();
		wait.until(ExpectedConditions.visibilityOf(DecouvrirVosServices));
	}
}
