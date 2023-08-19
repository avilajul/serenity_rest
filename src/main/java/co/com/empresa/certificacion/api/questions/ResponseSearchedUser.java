package co.com.empresa.certificacion.api.questions;

import co.com.empresa.certificacion.api.exceptions.ErrorExceptions;
import co.com.empresa.certificacion.api.models.ResponseBody;
import co.com.empresa.certificacion.api.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.empresa.certificacion.api.utils.constants.StatusCodes.STATUS_CODE_200;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
public class ResponseSearchedUser implements Question<Boolean> {
    private final UserData userData;
    public ResponseSearchedUser(UserData userData) {
        this.userData = userData;
    }
    public static ResponseSearchedUser withTheRightUserData(UserData userData){
        return new ResponseSearchedUser(userData);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean expectedResult = false;
        ResponseBody responseBody;

        if (lastResponse().statusCode() != STATUS_CODE_200){
            throw new ErrorExceptions("ERROR: El servicio respondió con código " + lastResponse().statusCode());
        }else {
            responseBody = lastResponse().jsonPath().getObject("data", ResponseBody.class);
        }

        if (responseBody.getId().equals(userData.getId())
                && responseBody.getEmail().equals(userData.getEmail())
                && responseBody.getFirst_name().equals(userData.getFirst_name())
                && responseBody.getLast_name().equals(userData.getLast_name())
                && responseBody.getAvatar().equals(userData.getAvatar())
        ){
                    expectedResult = true;
        }
        return expectedResult;
    }
}
