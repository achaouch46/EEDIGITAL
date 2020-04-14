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
import com.mutex.selenium.forme.espaceemployeur.homePageMenu.UtiliserVosServicesPage;
import com.mutex.selenium.forme.espaceemployeur.suivreVosSalaries.ListeDuPersonnelCouvert;
import com.mutex.selenium.forme.espaceemployeur.utiliserVosServices.DecouvrirVosServices;
import com.mutex.selenium.listeners.TestAllureListener;
import com.mutex.selenium.testdata.LoginInput;
import com.mutex.selenium.testdata.SuivreVosSalariesInput;
import io.qameta.allure.Description;


@Listeners({ TestAllureListener.class })
public class EESoDig55 {

	public BasePage basePage;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public UtiliserVosServicesPage utiliserVosServicesPage;
	public DecouvrirVosServices decouvrirVosServices;
	
	
	@BeforeMethod // this method will be executed before every @test method
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.initialize_driver();
		driver.get(basePage.getUrl());
		loginPage = new LoginPage(driver);
	}

	@Test(retryAnalyzer = MyRetry.class)
	@Description("Découvrir vos services")
	public void SoDig55() {
		LoginInput loginInput = LoginInput.nonDsn();
		loginPage.login(loginInput.getMail(), loginInput.getPw());
		
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getEspaceEmployeuPageTitle(), "Espace employeur");
		homePage.clickUtiliserVosServices();
		
		utiliserVosServicesPage = new UtiliserVosServicesPage(driver);
		utiliserVosServicesPage.clickDecouvrirVosServices();
		
		decouvrirVosServices = new DecouvrirVosServices(driver);
		decouvrirVosServices.DecouvrirVosServicesAffichage();
		
	}

	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}

}
