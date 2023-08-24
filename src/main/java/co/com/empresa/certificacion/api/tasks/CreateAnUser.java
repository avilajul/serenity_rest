package co.com.empresa.certificacion.api.tasks;

import co.com.empresa.certificacion.api.models.UserData;
import co.com.empresa.certificacion.api.utils.RequestBody;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.empresa.certificacion.api.utils.constants.Constants.*;
import static co.com.empresa.certificacion.api.utils.constants.Constants.APPLICATION_JSON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateAnUser implements Task {
    UserData userData;
    public CreateAnUser(UserData userData) {
        this.userData = userData;
    }
    public static CreateAnUser withTheData(UserData userData) {
        return instrumented(CreateAnUser.class, userData);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(USERS_LOCATION).with(
                        request -> request.relaxedHTTPSValidation()
                                .header(CONTENT_TYPE, APPLICATION_JSON)
                                .header(ACCEPT, APPLICATION_JSON)
                                .body(RequestBody.createUserData(userData))
                )
        );
    }
}
