package co.com.empresa.certificacion.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/delete_an_user.feature",
        glue = "co.com.empresa.certificacion.api.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class DeleteAnUser {
}
