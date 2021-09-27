package ApiTest;

public class apiTest {
    public static void main(String[] args){
        String url = "https://jsonplaceholder.typicode.com";
        String type = "GET";
        HttpUtil util = new HttpUtil(url);
        String result = "";
        try {
            result = util.testing("/posts", "GET");

        }catch(Exception e){
            System.out.println(e.toString());
        }
        try{
            result = util.testing("/posts", "POST");
            System.out.println(result);
        }catch(Exception e){
            System.out.println(e.toString());
        }


    }
}
