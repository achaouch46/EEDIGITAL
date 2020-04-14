package com.mutex.selenium.forme.espaceemployeur.homePageMenu;

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

public class SuivreVosSalariesPage extends BasePage {

	@FindBy(xpath = "//ul[@id='sous-menu']/li[1]/a")
	WebElement ListeDuPersonnelCouvert;
	
	private WebDriver driver;

	public SuivreVosSalariesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("On Ouvre le Menu 'Liste-du-personnel-couvert'.")
	public void clickListeDuPersonnelCouvert() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ListeDuPersonnelCouvert));
		ListeDuPersonnelCouvert.click();
	}

}
