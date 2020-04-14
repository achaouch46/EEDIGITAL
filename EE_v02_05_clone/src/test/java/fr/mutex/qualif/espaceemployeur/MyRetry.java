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
import org.testng.Assert;
import org.testng.annotations.Test;



import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class MyRetry implements IRetryAnalyzer {
 
  private int retryCount = 0;
  private static final int maxRetryCount = 2;
 
  @Override
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}