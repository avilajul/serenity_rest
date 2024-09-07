package co.com.empresa.certificacion.api.tasks;

import co.com.empresa.certificacion.api.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.empresa.certificacion.api.utils.constants.Constants.USERS_LOCATION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteAnUser implements Task {
    private final UserData userData;
    public DeleteAnUser(UserData userData) {
        this.userData = userData;
    }
    public static DeleteAnUser byId(UserData userData) {
        return instrumented(DeleteAnUser.class, userData);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(USERS_LOCATION + userData.getUser_id())
        );
    }
}
