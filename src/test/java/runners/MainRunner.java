package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//Connecting test steps with feature files
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        //selecting tag for running specific test cases - Collections
        tags = "@regression",
        //Console results...(Check!)
        monochrome = true, dryRun = false,
        //Creating HTML-JSON reports after test are done
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)

//This is the Main runner where Test should be executed
public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    //Parallel running test cases (All at once or one by one)
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}