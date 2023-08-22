package co.com.empresa.certificacion.api.models;

public enum Routes {
    FULL_USER_UPDATE ("src/test/resources/files/update_user_put_method.json"),
    PARTIAL_USER_DATA ("src/test/resources/files/update_user_put_method.json");

    private final String routeFile;
    Routes(String routeFile) {
        this.routeFile = routeFile;
    }
    public String getRouteFile(){
        return routeFile;
    }

}
