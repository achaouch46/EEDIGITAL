package fr.mutex.qualif.espaceemployeur;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mutex.selenium.Base.BasePage;
import com.mutex.selenium.forme.espaceemployeur.HomePage;
import com.mutex.selenium.forme.espaceemployeur.LoginPage;
import com.mutex.selenium.forme.espaceemployeur.suivreVosSalaries.ListeDuPersonnelCouvert;
import com.mutex.selenium.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ TestAllureListener.class })
public class test3 {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage espaceEmployeurPage;
	public ListeDuPersonnelCouvert listeDuPersonnelCouvert;
	//JavascriptExecutor jsExecutor;
	
	@BeforeMethod // this method will be executed before every @test method
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.initialize_driver();
		driver.get("https://www.amazon.fr/");
		loginPage = new LoginPage(driver);
	}

	@Test(retryAnalyzer = MyRetry.class)
	@Description("ouvrir amazon test 2")
	public void amazon2() {

		loginPage.amazon2("pc");
		
	}

	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}

}
