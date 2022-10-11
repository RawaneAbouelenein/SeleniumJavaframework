//package StepDefinitions;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Scenario2_salto {
//	public static WebDriver driver;
//	private WebElement iframe;
//	//	//chromecredentials
//	@Given("user is on google search page")
//	public void user_is_on_google_search_page() throws InterruptedException {
//		//chrome driver data
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");	 
//		String url = "https://self.sso-dev.infra.ftgroup/lang/en/popup.html/";
//		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		String parent = driver.getWindowHandle();
//		Set<String> windows=driver.getWindowHandles();
//
//		System.out.println("insidestep2");
//	}
//	//popupblocker
//	@Given("popup")
//	public void popup() throws InterruptedException {
//
//		System.out.println("driver="+driver);
//		String parent = driver.getWindowHandle();
//		Set<String> s = driver.getWindowHandles();
//		java.util.Iterator<String> I1 = s.iterator();
//		while (I1.hasNext()) {
//			String child_window = I1.next();
//			if (!parent.equals(child_window)) {
//				driver.switchTo().window(child_window);
//				System.out.println(driver.switchTo().window(child_window).getTitle());
//				driver.close();
//			}
//		}
//		// switch to the parent window
//		driver.switchTo().window(parent);
//
//
//	}
//
//	//guardian credentials
//	@When("user enters a text in search box")
//	public void user_enters_a_text_in_search_box() throws InterruptedException {
//		driver.get("https://self.sso-dev.infra.ftgroup/");
//		driver.findElement(By.xpath("//a[normalize-space()='ici']")).click();
//		driver.findElement(By.id("user")).sendKeys("amam0001");
//		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/form/span/input[1]")).click();
//		driver.findElement(By.id("password")).sendKeys("amam0001");
//		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/form/span/input[2]")).click();
//		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/form/span/span/a/span")).click();
//		popup();
//		System.out.println("insidestep3");
//	}
//
//	////recherche part
//	@And("hits enter")
//	public void hits_enter() {
//		//open saltoam
//		driver.get("https://rcorp-bpm-02metro-saltoam-off.sso-dev.infra.ftgroup/binSalto");
//		//open recherche
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		WebElement button1 = driver.findElement(By.xpath("//span[contains(text(),'Recherche')]"));
//		JavascriptExecutor java1=(JavascriptExecutor)driver;
//		java1.executeScript("arguments[0].click();", button1);
//
//		//				//drop list
//		Select objSelect=new Select(driver.findElement(By.id("e02b3797")));
//		objSelect.selectByVisibleText("Création");
//		Select objSelect1=new Select(driver.findElement(By.id("26443e10")));
//		objSelect1.selectByVisibleText("En cours de fabrication");
//		driver.findElement(By.id("385c1f5")).sendKeys("Choix Prestation");
//		Select objSelect2=new Select(driver.findElement(By.id("c5eac872")));
//		objSelect2.selectByVisibleText("A réaliser");
//		//lancer recherche
//		driver.findElement(By.xpath("//button[@name='OperatorQueryInformations_TmpOperatorQuery_10']")).click();
//		try {
//			Thread.sleep(30);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("insidestep4");
//	}
//	@Then("user is navigated to search results")
//	public void user_is_navigated_to_search_results() throws InterruptedException {
//		Thread.sleep(10000);
//		driver.findElement(By.xpath(
//				"//th[@data-attribute-name='Et.']//a[@title='Cliquer pour filtrer']"))
//		.click();
//		driver.findElement(By.xpath(
//				"//input[@id='cc58b261']"))
//		.click();
//		driver.findElement(By.xpath("//button[normalize-space()='Appliquer']")).click();
//		//doubleclick(DPS-1318337)
//		Thread.sleep(5000);
//		WebElement row = driver.findElement(By.xpath(
//				"//tr[@id='$PTmpOperatorQuery$pResultOperatorQueryList$l16']"));
//		System.out.println(row);
//		Actions act = new Actions(driver);
//		act.doubleClick(row).perform();
//		System.out.println("done");
//		Thread.sleep(5000);
//	}
//
//
////	@Then("scenario1")
////	public void scenario1() throws InterruptedException {
////		//scenario1
////		//		Thread.sleep(5000);
////		//	    iframe = driver.findElement(By.xpath("//iframe[@id='PegaGadget0Ifr']"));
////		//	    driver.switchTo().frame(iframe);
////		//	    WebElement button2 = driver.findElement(By.xpath("//a[contains(text(),'Choix Prestation')]"));
////		//	    button2.click();
////		//	    System.out.println("Element with text(): " + button2.getText());
////		//		driver.switchTo().parentFrame();
////		//		Thread.sleep(10000);
////		//		 iframe = driver.findElement(By.xpath("//iframe[@id='PegaGadget1Ifr']"));
////		//		    driver.switchTo().frame(iframe);
////		//			WebElement button3 = driver.findElement(By.xpath("//a[contains(text(),'Tout supprimer')]"));
////		//		    button3.click();
////		//		 System.out.println("tout supprimer");
////		//		 driver.switchTo().parentFrame();
////		//		 Thread.sleep(10000);
////		//		    WebElement button4 = driver.findElement(By.xpath("//span[normalize-space()='Ajout cordon sur EAS']"));
////		//		    button4.click();
////		//			Thread.sleep(10000);
////
////	}
//	//			
//	@Then("scenario2")
//	public void scenario2() throws InterruptedException {	
//	///scenario2
//		Thread.sleep(10000);
//		//open autre activiter 
//		iframe = driver.findElement(By.xpath("//iframe[@id='PegaGadget0Ifr']"));
//		driver.switchTo().frame(iframe);
//		WebElement button5 = driver.findElement(By.xpath("//a[contains(text(),'Autres activités')]"));
//		button5.click();
//		System.out.println("Element with text(): " + button5.getText());
//		//			driver.switchTo().parentFrame();
//		Thread.sleep(10000);
//		//driver.switchTo().parentFrame();
//		//			Pointing on Ajouter un travail
//		WebElement Ajoutertravail = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[6]/td[2]"));
//		new Actions(driver)
//		.moveToElement(Ajoutertravail)
//		.perform();
//		System.out.println("Ajouter un travail");
//		//click on Lancer un report de date
//		WebElement button7 = driver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr[4]/td[2]"));
//		button7.click();
//		System.out.println("Lancer un report de date");
//		Thread.sleep(10000);	    
//		//after openning Lancer un report de date
//		
//		
//
//		WebElement selectElement = driver.findElement(By.id("SelectType"));
//		//Now use select
//		Select select = new Select(selectElement);
//		select.selectByVisibleText("CLIENT");
//		System.out.println("CLIENT");
//		Thread.sleep(5000);
//		WebElement selectElement2 = driver.findElement(By.id("Selectreason"));
//		//Now use select	
//		Select select2 = new Select(selectElement2);
//		select2.selectByVisibleText("Desserte interne pas realisee");
//		System.out.println("Desserte interne pas realisee");
//		Thread.sleep(5000);
//		driver.findElement(By.id("2467bdaa")).sendKeys("test");
//		Thread.sleep(5000);
//		driver.findElement(By.id("1eb53eab")).sendKeys("07/10/2022");
//		Thread.sleep(10000);
//
//}
//}
////
////
