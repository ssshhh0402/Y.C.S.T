import org.json.simple.JSONObject;

public class User {
    long id;
    String email, password;


    User(JSONObject jo){
        this.id = (long)jo.get("id");
        this.email = (String)jo.get("email");
        this.password = (String)jo.get("password");
    }
}
