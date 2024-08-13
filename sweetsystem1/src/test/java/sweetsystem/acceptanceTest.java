package sweetsystem;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(features="myFeatures" ,
plugin= {"summary", "html:target/cucumber/report.html"},
monochrome=true,
snippets=SnippetType.CAMELCASE,
glue={"sweetsystem"})




public class acceptanceTest{
}

