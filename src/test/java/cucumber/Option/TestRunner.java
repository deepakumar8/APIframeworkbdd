package cucumber.Option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features", plugin="json:target/jsonreports/APIrerport.json",
		glue={"StepDefinition"}
				//,tags="@Deleteplace"
		)
public class TestRunner {

	
}
