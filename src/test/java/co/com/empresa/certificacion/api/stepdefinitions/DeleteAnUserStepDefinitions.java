package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseDeletedUser;
import co.com.empresa.certificacion.api.tasks.DeleteAnUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteAnUserStepDefinitions {
    @Given("^julian wants to delete a specific user$")
    public void julianWantsToDeleteASpecificUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }

    @When("^julian deletes a specific user$")
    public void julianDeletesASpecificUser(List<UserData> userData) {
        theActorInTheSpotlight().attemptsTo(DeleteAnUser.byId(userData.get(0)));
    }

    @Then("^julian gets a response that he was deleted$")
    public void julianGetsAResponseThatHeWasDeleted() {
        theActorInTheSpotlight().should(seeThat(ResponseDeletedUser.isSuccessful()));
    }
}
