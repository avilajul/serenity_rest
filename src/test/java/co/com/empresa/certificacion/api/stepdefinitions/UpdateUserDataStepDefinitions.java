package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.ResponseUpdatedUserData;
import co.com.empresa.certificacion.api.tasks.UpdateData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserDataStepDefinitions {
    @Given("^julián who wants to update the data of a specific user$")
    public void juliánWhoWantsToUpdateTheDataOfASpecificUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }

    @When("^julian updates the data of a specific user$")
    public void julianUpdatesTheDataOfASpecificUser(List<UserData> userData) {
        theActorInTheSpotlight().attemptsTo(UpdateData.forTheUser(userData.get(0)));
    }

    @Then("^julian gets a response that he was updated$")
    public void julianGetsAResponseThatHeWasUpdated() {
        theActorInTheSpotlight().should(seeThat(ResponseUpdatedUserData.isSuccessful()));
    }
}
