package co.com.empresa.certificacion.api.questions;

import co.com.empresa.certificacion.api.exceptions.ErrorExceptions;
import co.com.empresa.certificacion.api.models.ResponseBody;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.empresa.certificacion.api.utils.constants.StatusCodes.STATUS_CODE_200;
import static co.com.empresa.certificacion.api.utils.constants.StatusCodes.STATUS_CODE_201;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CreatedUserResponse implements Question <Boolean> {

    public static CreatedUserResponse wasSuccessful() {
        return new CreatedUserResponse();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean expectedResult = false;
        ResponseBody responseBody;

        if (lastResponse().statusCode() != STATUS_CODE_201){
            throw new ErrorExceptions("ERROR: El servicio respondió con código " + lastResponse().statusCode());
        }else {
            responseBody = lastResponse().jsonPath().getObject("", ResponseBody.class);
        }

        if (responseBody.getId().isEmpty() || responseBody.getCreatedAt().isEmpty()){
            throw new ErrorExceptions("ERROR: El servicio no creó el usuario");
        }else {
            expectedResult = true;
        }
        return expectedResult;
    }
}
