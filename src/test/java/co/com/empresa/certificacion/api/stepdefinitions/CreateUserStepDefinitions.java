package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.CreatedUserResponse;
import co.com.empresa.certificacion.api.questions.ResponseDeletedUser;
import co.com.empresa.certificacion.api.tasks.CreateAnUser;
import co.com.empresa.certificacion.api.tasks.DeleteAnUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDefinitions {
    @Given("^julian wants to create a user$")
    public void julianWantsToCreateAUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }

    @When("^julian creates a user$")
    public void julianCreatesAUser(List<UserData> userData) {
        theActorInTheSpotlight().attemptsTo(CreateAnUser.withTheData(userData.get(0)));
    }

    @Then("^julian gets a response that he was created$")
    public void julianGetsAResponseThatHeWasCreated() {
        theActorInTheSpotlight().should(seeThat(CreatedUserResponse.wasSuccessful()));
    }
}
