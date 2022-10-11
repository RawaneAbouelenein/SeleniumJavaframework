package StepDefinitions;


	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features= "src/test/resources/Features",
			glue= {"StepDefinitions"},
			plugin = {"pretty","html:target/cucumber.html","junit:target/cucumber.xml",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			monochrome = true,
			dryRun = false,
			
//			publish = true
//			dryRun=false,		
//			publish=true,
			tags="@scenario1.feature"
			)

	public class TestRunner {
	}


