package co.com.empresa.certificacion.api.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/update_user_info.feature",
        glue = "co.com.empresa.certificacion.api",
        snippets = SnippetType.CAMELCASE
)
public class UpdateUserInfo {
}
