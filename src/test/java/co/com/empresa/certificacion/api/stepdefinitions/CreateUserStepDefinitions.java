package co.com.empresa.certificacion.api.stepdefinitions;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.questions.CreatedUserResponse;
import co.com.empresa.certificacion.api.tasks.CreateAnUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.empresa.certificacion.api.utils.constants.Constants.REQRES_URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDefinitions {
    @Given("^julian wants to create a user$")
    public void julianWantsToCreateAUser() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(REQRES_URL_BASE));
    }

    @When("^julian creates a user$")
    public void julianCreatesAUser(DataTable userData) {
        theActorInTheSpotlight().attemptsTo(CreateAnUser.withTheData(UserData.setData(userData).get(0)));
    }

    @Then("^julian gets a response that he was created$")
    public void julianGetsAResponseThatHeWasCreated() {
        theActorInTheSpotlight().should(seeThat(CreatedUserResponse.wasSuccessful()));
    }
}
