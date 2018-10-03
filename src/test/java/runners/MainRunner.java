package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"pretty",
				  "html:target/cucumber",
				  "json:target/cucumber.json",
				  "rerun:target/rerun.txt"},
	   features = "src/test/resources/features",
		
		glue = "steps",
		tags = "@test",
		dryRun = false
		)
public class MainRunner extends AbstractTestNGCucumberTests{

}
