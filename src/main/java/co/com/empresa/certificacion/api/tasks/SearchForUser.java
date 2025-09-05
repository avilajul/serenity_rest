package co.com.empresa.certificacion.api.tasks;

import co.com.empresa.certificacion.api.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.empresa.certificacion.api.utils.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchForUser implements Task {
    private final UserData userData;

    public SearchForUser(UserData userData) {
        this.userData = userData;
    }

    public static SearchForUser byId(UserData userData) {
        return instrumented(SearchForUser.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String resource = USERS_LOCATION + userData.getUser_id();
        actor.attemptsTo(
                Get.resource(resource).with(
                        request -> request.relaxedHTTPSValidation()
                                .header(CONTENT_TYPE, APPLICATION_JSON)
                                .header(ACCEPT, APPLICATION_JSON)
                                .header(X_API_KEY,REQRES_FREE_V1)
                )
        );
    }
}
