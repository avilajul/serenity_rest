package co.com.empresa.certificacion.api.models;

public enum Routes {
    FULL_USER_UPDATE ("src/test/resources/files/update_user_put_method.json"),
    PARTIAL_USER_DATA ("src/test/resources/files/update_user_put_method.json"),
    DATA_OF_THE_NEW_USER ("src/test/resources/files/create_user.json");


    private final String routeFile;
    Routes(String routeFile) {
        this.routeFile = routeFile;
    }
    public String getRouteFile(){
        return routeFile;
    }

}
