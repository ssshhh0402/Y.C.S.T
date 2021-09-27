import java.util.ArrayList;

public class main {
    static long [][] base;
    static ArrayList<Truck> trucks;
    public static void main(String[] args){
        String url = " https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users";
        HttpUtil util = new HttpUtil(url);
        String result = "";
//        try {
//            result = util.testing("/hello", "GET");
//
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
//        System.out.println(result);
//
//        try{
//            result = util.login("/user/login", "POST");
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
//        System.out.println(result);
//        try{
//            ArrayList<Post> results = util.getPosts("/posts", "GET");
//            for(Post item : results){
//                System.out.println("----------------");
//                System.out.println("ID : " + item.id);
//                System.out.println("TITLE : " + item.title);
//                System.out.println("BODY : " + item.body);
//                System.out.println("----------------");
//
//            }
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
//        try{
//            ArrayList<User> results = util.getUsers("/user/", "GET");
//            for(User user : results){
//                System.out.println("----------------------");
//                System.out.println("ID : " + user.id);
//                System.out.println("EMAIL : " + user.email);
//                System.out.println("PWD : " + user.password);
//                System.out.println("----------------------");
//            }
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
        try{
            util.start();
            base = util.location();
            trucks = util.getTrucks(base.length);
            for(Truck truck: trucks){
                System.out.println("X : " + truck.x);
                System.out.println("Y : " + truck.y);
                System.out.println("ID : " + truck.id);
                System.out.println("Count : " + truck.count);
                System.out.println("-----");
            }
            util.Moving();
            util.Score();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
