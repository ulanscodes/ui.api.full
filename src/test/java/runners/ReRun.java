package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class ReRun {
	
	@CucumberOptions(
			plugin = {"pretty",
					  "html:target/cucumber",
					  "json:target/cucumber.json"},
			
			features = "target/rerun.txt",
			
			glue = "steps",
			dryRun = false
			)
	public class MainRunner extends AbstractTestNGCucumberTests{

	}

}
