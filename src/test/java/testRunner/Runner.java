package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/PetById.feature"},
        glue= {"stepDefination","hooks"},
        plugin= {"pretty","json:target/jsonReports/cucumber-report.json" }
		//tags= "@sanity"
)


public class Runner {

}
