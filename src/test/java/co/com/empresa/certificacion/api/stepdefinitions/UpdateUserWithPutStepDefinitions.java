package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseUpdatedUserInformation;
import co.com.empresa.certificacion.api.tasks.UpdateInformation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserWithPutStepDefinitions {
    @Given("^julian who wants to update the information of a specific user$")
    public void julianWhoWantsToUpdateTheInformationOfASpecificUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }
    @When("^julian updates the information for a specific user$")
    public void julianUpdatesTheInformationForASpecificUser(DataTable userData) {
        theActorInTheSpotlight().attemptsTo(UpdateInformation.forTheUser(UserData.setData(userData).get(0)));
    }
    @Then("^julian receives a response that the user was updated$")
    public void julianReceivesAResponseThatTheUserWasUpdated() {
        theActorInTheSpotlight().should(seeThat(ResponseUpdatedUserInformation.updateSuccessful()));
    }
}
