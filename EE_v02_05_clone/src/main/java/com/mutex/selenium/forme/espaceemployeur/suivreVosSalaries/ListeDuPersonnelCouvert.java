package com.mutex.selenium.forme.espaceemployeur.suivreVosSalaries;

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

public class ListeDuPersonnelCouvert extends BasePage {

	

	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Liste du personnel couvert'])[3]/following::summary[1]")
	WebElement RechercheVosSalaries;
	
	@FindBy(id = "salarie_search_form_rechercher")
	WebElement lancerRecherche;
	
	@FindBy(id = "tableListSalaries")
	WebElement tableListSalaries;
	
	private WebDriver driver;

	public ListeDuPersonnelCouvert(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("On Ouvre le Menu 'Recherche-vos-salarie'.")
	public void clickRechercheVosSalaries() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RechercheVosSalaries));
		RechercheVosSalaries.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@type = 'button' and @data-id = 'salarie_search_form_mesEtablissements']"))));

	}
	
	@Step("On choisit le num du Siret dans le recerche..")
	public void setSiret(String value) {
		(driver.findElement(By.xpath("//*[@type = 'button' and @data-id = 'salarie_search_form_mesEtablissements']"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[(text() = ' "+value+"' or . = ' "+value+"')]"))));
		(driver.findElement(By.xpath(".//*[(text() = ' "+value+"' or . = ' "+value+"')]"))).click();
	}
	
	@Step("On choisit le num du contrat dans le recerche.")
	public void setContrat(String value) {
		(driver.findElement(By.xpath("//*[@type = 'button' and @data-id = 'salarie_search_form_mesContrats']"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[(text() = ' "+value+"' or . = ' "+value+"')]"))));
		(driver.findElement(By.xpath("//*[(text() = ' "+value+"' or . = ' "+value+"')]"))).click();
	}
	
	@Step("On choisit le type du College dans le recerche.")
	public void setCollege(String value) {
		(driver.findElement(By.xpath("//*[@type = 'button' and @data-id = 'salarie_search_form_mesColleges']"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[(text() = ' "+value+"' or . = ' "+value+"')]"))));
		(driver.findElement(By.xpath("//*[(text() = ' "+value+"' or . = ' "+value+"')]"))).click();
	}
	
	
	
	@Step("On Ouvre le bouton 'Lancer Recherche'.")
	public void clickLancerRecherche() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		lancerRecherche.click();
		wait.until(ExpectedConditions.visibilityOf(tableListSalaries));

	}
	
	
	@Step("On Recherche la liste des salariers dans le tableau")
	public boolean RechercheListeDansLetableau(String tableID, String tableColumnNumber, String[] expectedValues) {
			boolean found = true;
			WebElement el = driver.findElement(By.xpath("//table[@id='"+tableID+"']/tbody"));
			List<WebElement> elements = el.findElements(By.tagName("tr"));
			int RowsCount = elements.size();
			int tableRowNumber =1;
			do {
				System.out.println("###### Exécution du cas de test : under while");
				for(String expectedValue : expectedValues) {
					System.out.println("###### Exécution du cas de test : under for");
					WebElement element = driver.findElement(By.xpath("//table[@id='"+ tableID +"']/tbody/tr[" + tableRowNumber + "]/td[" + tableColumnNumber + "]"));	
					Assert.assertEquals(element.getText().toString(),expectedValue);
					if(element.getText().toString().equals(expectedValue)) {
						tableRowNumber++;
					} else {
						found = false;
						break;
					}
				}
			} while((RowsCount == expectedValues.length)&&(tableRowNumber<RowsCount) && ( found == true));
		return found;
	}
	
	
	
	
	
	
	
}
