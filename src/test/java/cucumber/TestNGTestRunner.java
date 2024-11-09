package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="rahulsheetyacademy.stepdefinition",
monochrome=true,plugin= {"html:target/cucumber.htm"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}

