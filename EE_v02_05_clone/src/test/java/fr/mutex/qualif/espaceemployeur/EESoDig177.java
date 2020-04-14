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
import com.mutex.selenium.forme.espaceemployeur.homePageMenu.SuivreVosSalariesPage;
import com.mutex.selenium.forme.espaceemployeur.suivreVosSalaries.ListeDuPersonnelCouvert;
import com.mutex.selenium.listeners.TestAllureListener;
import com.mutex.selenium.testdata.LoginInput;
import com.mutex.selenium.testdata.SuivreVosSalariesInput;
import io.qameta.allure.Description;


@Listeners({ TestAllureListener.class })
public class EESoDig177 {

	public BasePage basePage;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public SuivreVosSalariesPage suivreVosSalariesPage;
	public ListeDuPersonnelCouvert listeDuPersonnelCouvert;
	
	@BeforeMethod // this method will be executed before every @test method
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.initialize_driver();
		driver.get(basePage.getUrl());
		loginPage = new LoginPage(driver);
	}

	@Test(retryAnalyzer = MyRetry.class)
	@Description("Suivre salariers Siret NON DSN")
	public void SoDig177() {
		LoginInput loginInput = LoginInput.nonDsn();
		SuivreVosSalariesInput svsInput = SuivreVosSalariesInput.nonDsn();
		
		loginPage.login(loginInput.getMail(), loginInput.getPw());
		
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getEspaceEmployeuPageTitle(), "Espace employeur");
		homePage.clickSuivreVosSalaries();
		
		suivreVosSalariesPage = new SuivreVosSalariesPage(driver);
		suivreVosSalariesPage.clickListeDuPersonnelCouvert();
		
		listeDuPersonnelCouvert = new ListeDuPersonnelCouvert(driver);
		listeDuPersonnelCouvert.clickRechercheVosSalaries();
		listeDuPersonnelCouvert.setSiret(svsInput.getSiret());
		listeDuPersonnelCouvert.setContrat(svsInput.getContrat());
		listeDuPersonnelCouvert.setCollege(svsInput.getcollege());
		listeDuPersonnelCouvert.clickLancerRecherche();
		String[] valueslistNonDsn = {"JUMEAU STEPHANIE","MAANANEc MERYEM"};
		//Assert.assertTrue(listeDuPersonnelCouvert.RechercheListeDansLetableau("tableListSalaries","1",svsInput.getvalueList()));
		Assert.assertTrue(listeDuPersonnelCouvert.RechercheListeDansLetableau("tableListSalaries","1",valueslistNonDsn));

	}
	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}

}
