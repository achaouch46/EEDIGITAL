package com.mutex.selenium.forme.espaceemployeur.homePageMenu;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mutex.selenium.Base.BasePage;
import io.qameta.allure.Step;

public class ConsulterVosInformationsPage extends BasePage {
	
	@FindBy(xpath = "//a[@href='/Consulter-vos-informations/Documents-contractuels']")
	WebElement DocumentsContractuels;
	
	private WebDriver driver;

	public ConsulterVosInformationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Step("On Ouvre le sous Menu 'Documents-contractuels'.")
	public void clickDocumentsContractuels() {
		DocumentsContractuels.click();
	}
}
