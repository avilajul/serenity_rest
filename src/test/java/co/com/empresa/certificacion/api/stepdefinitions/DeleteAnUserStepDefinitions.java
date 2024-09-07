package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseDeletedUser;
import co.com.empresa.certificacion.api.tasks.DeleteAnUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteAnUserStepDefinitions {
    @Given("^julian wants to delete a specific user$")
    public void julianWantsToDeleteASpecificUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }

    @When("^julian deletes a specific user$")
    public void julianDeletesASpecificUser(DataTable userData) {
        theActorInTheSpotlight().attemptsTo(DeleteAnUser.byId(UserData.setData(userData).get(0)));
    }

    @Then("^julian gets a response that he was deleted$")
    public void julianGetsAResponseThatHeWasDeleted() {
        theActorInTheSpotlight().should(seeThat(ResponseDeletedUser.isSuccessful()));
    }
}
