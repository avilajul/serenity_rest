package co.com.empresa.certificacion.api.tasks;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.utils.RequestBody;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.empresa.certificacion.api.utils.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateInformation implements Task {
    private final UserData userData;

    public UpdateInformation(UserData userData) {
        this.userData = userData;
    }
    public static UpdateInformation forTheUser(UserData userData){
        return instrumented(UpdateInformation.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(USERS_LOCATION+userData.getUser_id()).with(
                        request -> request.relaxedHTTPSValidation()
                                .header(CONTENT_TYPE, APPLICATION_JSON)
                                .header(ACCEPT,APPLICATION_JSON)
                                .body(RequestBody.updateUserInformation(userData))
                )
        );
    }
}
