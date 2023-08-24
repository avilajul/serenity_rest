package co.com.empresa.certificacion.api.utils;

import co.com.empresa.certificacion.api.exceptions.FileHandlingExceptions;
import co.com.empresa.certificacion.api.models.Routes;
import co.com.empresa.certificacion.api.models.UserData;

import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestBody {
    private RequestBody() {
    }

    public static String updateUserInformation(UserData userData) {
        String pathJson = Routes.valueOf("FULL_USER_UPDATE").getRouteFile();
        String jsonBody;
        try{
            jsonBody = new String(Files.readAllBytes(Paths.get(pathJson)));
            jsonBody = jsonBody.replace("$name", userData.getName())
                                .replace("$job", userData.getJob());
        } catch(Exception e){
            throw new FileHandlingExceptions();
        }

        return jsonBody;

    }
    public static String updateUserData(UserData userData){
        String pathJson = Routes.valueOf("PARTIAL_USER_DATA").getRouteFile();
        String jsonBody;
        try{
            jsonBody = new String(Files.readAllBytes(Paths.get(pathJson)));
            jsonBody = jsonBody.replace("$name", userData.getName());
        } catch(Exception e){
            throw new FileHandlingExceptions();
        }
        return jsonBody;
    }

    public static String createUserData(UserData userData){
        String pathJson = Routes.valueOf("DATA_OF_THE_NEW_USER").getRouteFile();
        String jsonBody;
        try{
            jsonBody = new String(Files.readAllBytes(Paths.get(pathJson)));
            jsonBody = jsonBody.replace("$username", userData.getUsername())
                    .replace("$email", userData.getEmail())
                    .replace("$password", userData.getPassword());
        } catch(Exception e){
            throw new FileHandlingExceptions();
        }
        return jsonBody;
    }


}
