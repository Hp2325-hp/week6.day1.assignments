package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/features/A5_Delete_Lead.feature",glue="steps",monochrome=true
,publish=true)
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
