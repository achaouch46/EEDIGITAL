package fr.mutex.qualif.espaceemployeur;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mutex.selenium.Base.BasePage;
import com.mutex.selenium.forme.espaceemployeur.HomePage;
import com.mutex.selenium.forme.espaceemployeur.LoginPage;
import com.mutex.selenium.forme.espaceemployeur.consulterVosInformations.DocumentsContractuelsPage;
import com.mutex.selenium.forme.espaceemployeur.homePageMenu.ConsulterVosInformationsPage;
import com.mutex.selenium.listeners.TestAllureListener;
import com.mutex.selenium.testdata.InfoCompte;
import com.mutex.selenium.testdata.LoginInput;
import com.mutex.selenium.testdata.SuivreVosSalariesInput;

import io.qameta.allure.Description;


@Listeners({ TestAllureListener.class })
public class EESoDig135 {

	public BasePage basePage;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public ConsulterVosInformationsPage consulterVosInformationsPage;
	public DocumentsContractuelsPage documentsContractuelsPage;
	
	@BeforeMethod // this method will be executed before every @test method
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.initialize_driver();
		driver.get(basePage.getUrl());
		loginPage = new LoginPage(driver);
	}

	@Test(retryAnalyzer = MyRetry.class)
	@Description("Documents liés à votre contrat")
	public void SoDig135() {
		LoginInput loginInput = LoginInput.nonDsn();
		SuivreVosSalariesInput svsInput = SuivreVosSalariesInput.nonDsn();
		InfoCompte infoCompte = InfoCompte.infoCompteNonDsn();
		
		loginPage.login(loginInput.getMail(), loginInput.getPw());
		
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getEspaceEmployeuPageTitle(), "Espace employeur");
		homePage.clickConsulterVosInformations();
		
		consulterVosInformationsPage = new ConsulterVosInformationsPage(driver);
		consulterVosInformationsPage.clickDocumentsContractuels();
		
		documentsContractuelsPage = new DocumentsContractuelsPage(driver);
		documentsContractuelsPage.clickLienVotreCentreDeGestion();
		
		Assert.assertTrue(documentsContractuelsPage.getSiret(infoCompte.getSiret()));
		Assert.assertTrue(documentsContractuelsPage.getRaisonSociale(infoCompte.getRaisonSociale()));
		Assert.assertTrue(documentsContractuelsPage.getNom(infoCompte.getNom()));
		Assert.assertTrue(documentsContractuelsPage.getPrenom(infoCompte.getPrenom()));
		Assert.assertTrue(documentsContractuelsPage.getTel(infoCompte.getTel()));
		Assert.assertTrue(documentsContractuelsPage.getEmail(infoCompte.getMail()));
	}

	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}

}
