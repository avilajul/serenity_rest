package co.com.empresa.certificacion.api.tasks;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.utils.RequestBody;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static co.com.empresa.certificacion.api.utils.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateData implements Task {
    private final UserData userData;

    public UpdateData(UserData userData) {
        this.userData = userData;
    }

    public static UpdateData forTheUser(UserData userData){
        return instrumented(UpdateData.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to(USERS_LOCATION+userData.getUser_id()).with(
                        request -> request.relaxedHTTPSValidation()
                                .header(CONTENT_TYPE, APPLICATION_JSON)
                                .header(ACCEPT,APPLICATION_JSON)
                                .header(X_API_KEY,REQRES_FREE_V1)
                                .body(RequestBody.updateUserData(userData))
                )
        );
    }
}
