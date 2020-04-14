package com.mutex.selenium.forme.espaceemployeur.consulterVosInformations;

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

public class DocumentsContractuelsPage extends BasePage {

	@FindBy(xpath = "//span[@class = 'ezstring-field' and (text() = 'Documents liés à votre contrat' or . = 'Documents liés à votre contrat')]")
	WebElement DocumentsLisVotreContrat;
	
	@FindBy(xpath = "//form[@id='FormulaireContact']/div/div/div/div/div[4]/div/div/div/button/span")
	WebElement Siret;
	
	@FindBy(xpath = "//input[@id='FormulaireContact_raisonSociale']")
	WebElement RaisonSociale;
	
	@FindBy(xpath = "//form[@id='FormulaireContact']/div/div/div/div/div[6]/div/div/div/button/span")
	WebElement Civilite;
	
	@FindBy(id = "FormulaireContact_nom")
	WebElement nom;
	
	@FindBy(id = "FormulaireContact_prenom")
	WebElement Prenom;
	
	@FindBy(id = "FormulaireContact_telephone")
	WebElement Tel;
	
	@FindBy(id = "FormulaireContact_email")
	WebElement Email;
	
	private WebDriver driver;

	public DocumentsContractuelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("On Vérifie l'affichage des 'Documents liés à votre contrat'.")
	public void clickRechercheVosSalaries() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DocumentsLisVotreContrat));
	}
	
	@Step("On click sur le lien 'votre centre de gestion'.")
	public void clickLienVotreCentreDeGestion() {
		(driver.findElement(By.xpath("//a[contains(text(),'votre centre de gestion')]"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[(text() = ' Nous contacter' or . = ' Nous contacter')]"))));
	}	
	
	@Step("On Vérifie la valeur 'Siret'.")
	public Boolean getSiret(String SIRET) {
		return Siret.getText().equals(SIRET);
	}
	
	@Step("On Vérifie la valeur 'Raison Sociale'.")
	public Boolean getRaisonSociale(String Raison_Sociale) {
		return RaisonSociale.getAttribute("value").equals(Raison_Sociale);
	}	
	
	@Step("On Vérifie la valeur 'Nom'.")
	public Boolean getNom(String Nom) {
		return nom.getAttribute("value").equals(Nom);
	}	
	
	@Step("On Vérifie la valeur 'Prenom'.")
	public Boolean getPrenom(String PRenom) {
		return Prenom.getAttribute("value").equals(PRenom);
	}	
	
	@Step("On Vérifie la valeur 'Telephone'.")
	public Boolean getTel(String Telephone) {
		return Tel.getAttribute("value").equals(Telephone);
	}	
	
	@Step("On Vérifie la valeur 'Email'.")
	public Boolean getEmail(String mail) {
		return Email.getAttribute("value").equals(mail);
	}	
	
	
	
}
