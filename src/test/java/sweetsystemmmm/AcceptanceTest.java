package sweetsystemmmm;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(features="/home/runner/work/swwet_mng_system/swwet_mng_system/MyFeatures" ,
plugin= {"summary", "html:target/cucumber/report.html"},
monochrome=true,
snippets=SnippetType.CAMELCASE,
glue={"sweetsystemmmm"})




public class AcceptanceTest{
}
