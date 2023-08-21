package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseSearchedUser;
import co.com.empresa.certificacion.api.tasks.SearchForUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

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
    public void julianSearchesForAUserByHisId(List<UserData> userData) {
        theActorInTheSpotlight().attemptsTo(SearchForUser.byId(userData.get(0)));
    }
    @Then("^julian receives information about the user$")
    public void julianReceivesInformationAboutTheUser(List<UserData> userData) {
        theActorInTheSpotlight().should(
                seeThatResponse("El servicio respondió satisfactoriamente",
                        response -> response.statusCode(STATUS_CODE_200)
                )
        );
        theActorInTheSpotlight().should(seeThat(ResponseSearchedUser.withTheRightUserData(userData.get(0))));
    }
}
