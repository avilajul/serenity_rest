package co.com.empresa.certificacion.api.questions;

import co.com.empresa.certificacion.api.exceptions.ErrorExceptions;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.empresa.certificacion.api.utils.constants.StatusCodes.STATUS_CODE_200;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseUpdatedUserData implements Question<Boolean> {
    public static ResponseUpdatedUserData isSuccessful(){
        return new ResponseUpdatedUserData();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean expectedResult = false;
        String responseBody;

        if (lastResponse().statusCode() != STATUS_CODE_200){
            throw new ErrorExceptions("ERROR: El servicio respondió con código " + lastResponse().statusCode());
        }else {
            responseBody = JsonPath.from(lastResponse().getBody().asString()).getString("updatedAt");
        }

        if (responseBody.isEmpty()){
            throw new ErrorExceptions("ERROR: El servicio no actualizó la información del usuario");
        }else {
            expectedResult = true;
        }
        return expectedResult;
    }
}
