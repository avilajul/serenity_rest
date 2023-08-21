package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseUpdatedUserInformation;
import co.com.empresa.certificacion.api.tasks.UpdateInformation;
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

public class UpdateUserWithPutStepDefinitions {
    @Given("^julian who wants to update the information of a specific user$")
    public void julianWhoWantsToUpdateTheInformationOfASpecificUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }
    @When("^julian updates the information for a specific user$")
    public void julianUpdatesTheInformationForASpecificUser(List<UserData> userData) {
        theActorInTheSpotlight().attemptsTo(UpdateInformation.forTheUser(userData.get(0)));
    }
    @Then("^julian receives a response that the user was updated$")
    public void julianReceivesAResponseThatTheUserWasUpdated() {
        theActorInTheSpotlight().should(seeThat(ResponseUpdatedUserInformation.updateSuccessful()));
    }
}
