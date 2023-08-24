package co.com.empresa.certificacion.api.questions;

import co.com.empresa.certificacion.api.exceptions.ErrorExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.empresa.certificacion.api.utils.constants.StatusCodes.STATUS_CODE_204;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseDeletedUser implements Question<Boolean> {

    public static ResponseDeletedUser isSuccessful() {
        return new ResponseDeletedUser();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean expectedResult = false;

        if (lastResponse().statusCode() != STATUS_CODE_204) {
            throw new ErrorExceptions("ERROR: El servicio respondió con código " + lastResponse().statusCode());
        } else {
            expectedResult = true;
        }
        return expectedResult;
    }
}
