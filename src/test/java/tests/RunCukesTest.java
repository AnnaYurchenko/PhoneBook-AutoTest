package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {"json:target/cucumber-report.json", "pretty"},
//        tags = "@positive_registration"
//        tags = "@negative_registration"
        tags = "@login"

)
public class RunCukesTest {
}

