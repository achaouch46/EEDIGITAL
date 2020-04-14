package com.mutex.selenium.forme.espaceemployeur;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mutex.selenium.Base.BasePage;

import io.qameta.allure.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class LoginPage extends BasePage {

	// 1.a: define page objects (PAGE OR) : using PageFactory Pattern

	@FindBy(id = "id1")
	WebElement emailId;

	@FindBy(id = "id2")
	WebElement password;

	@FindBy(name = "LoginButton")
	WebElement loginButton;

	@FindBy(id = "cookie-check-bt")
	WebElement cookieCheck;

	//public WebDriver driver;

	// 1.b: Constructor of page class and initialize elements with driver

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 2. Page methods - Actions:
	@Step("le titre de la page")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("se connecté avec mail: {0} et mot de passe: {1} step...")
	public void login(String mail, String pwd) {
		emailId.sendKeys(mail);
		password.sendKeys(pwd);
		cookieCheck.click();
		loginButton.click();
	}

}
