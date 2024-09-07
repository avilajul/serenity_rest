package co.com.empresa.certificacion.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/update_user_info.feature",
        glue = "co.com.empresa.certificacion.api.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class UpdateUserInfo {
}
