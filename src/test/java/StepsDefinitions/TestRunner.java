package StepsDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"StepsDefinitions"},

        monochrome = true,
        plugin = {"pretty", "html:target/TestReports/HTMLReports/report.html",
                "json:target/TestReports/JSONReports/report.json",
                "junit:target/TestReports/JUnitReports/report.xml"}
)
public class TestRunner {
}
