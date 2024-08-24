package sweetsystemmmm;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import static org.junit.Assert.*;

import io.cucumber.junit.*;
@RunWith(Cucumber.class)

@CucumberOptions(
  features= "C:\\Users\\acer\\eclipse-workspace\\sweetsystem\\Myfeatures" ,
plugin= {"summary", "html:target/cucumber/report.html"},
monochrome=true,
snippets=SnippetType.CAMELCASE,
glue={"sweetsystemmmm"})




public class AcceptanceTest{
}
