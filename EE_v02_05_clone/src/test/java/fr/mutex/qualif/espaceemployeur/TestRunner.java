package fr.mutex.qualif.espaceemployeur;

import org.testng.TestNG;

import com.mutex.selenium.listeners.ExtentReportListener;

public class TestRunner {
	
	static TestNG testNg;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ExtentReportListener ext = new ExtentReportListener();

		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {EESoDig177.class});
		testNg.addListener(ext);
		testNg.run();
		
		
	}

}
