import org.json.simple.JSONObject;

public class Post {
    long user_id, id;
    String title, body;

    Post(JSONObject jo){
        this.user_id = (long)jo.get("userId");
        this.id = (long)jo.get("id");
        this.title = (String)jo.get("title");
        this.body = (String)jo.get("body");
    }
}
