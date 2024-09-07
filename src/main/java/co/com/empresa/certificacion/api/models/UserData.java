package co.com.empresa.certificacion.api.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserData {
    private String user_id;
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String name;
    private String job;
    private String username;
    private String password;

    public static List<UserData> setData(DataTable dataTable){
        List<UserData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : mapInfo){
            data.add(new ObjectMapper().convertValue(map, UserData.class));
        }
        return data;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
