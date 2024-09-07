package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseSearchedUser;
import co.com.empresa.certificacion.api.tasks.SearchForUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static co.com.empresa.certificacion.api.utils.constants.StatusCodes.STATUS_CODE_200;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CheckSingleUserStepDefinitions {
    @Given("^julian enters the reqres api$")
    public void julianEntersTheReqresApi() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }
    @When("^julian searches for a user by his id$")
    public void julianSearchesForAUserByHisId(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(SearchForUser.byId(UserData.setData(dataTable).get(0)));
    }
    @Then("^julian receives information about the user$")
    public void julianReceivesInformationAboutTheUser(DataTable dataTable) {
        theActorInTheSpotlight().should(
                seeThatResponse("El servicio respondió satisfactoriamente",
                        response -> response.statusCode(STATUS_CODE_200)
                )
        );
        theActorInTheSpotlight().should(seeThat(ResponseSearchedUser.withTheRightUserData(UserData.setData(dataTable).get(0))));
    }
}
