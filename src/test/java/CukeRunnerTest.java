import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Juan_Rodriguez on 6/30/2015.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report"},
//        features="src/test/resources",
        tags = {"@prueba"}
)


public class CukeRunnerTest {

}
