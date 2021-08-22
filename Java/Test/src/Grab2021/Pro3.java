//package Grab2021;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//
//public class Pro3 {
//    static int [][] used;
//    static ArrayList<ArrayList<int[]>> cheking = new ArrayList<ArrayList<int[]>>();
//    static int answer = 0;
//    static int n;
//    public static boolean isPos(String target, String now){
//        int n = target.length();
//        boolean [] temps = new boolean[n];
//        int count = 0;
//        for(int i = 0 ;i < n; i++){
//            for(int y = 0; y < n; y++){
//                if(target.charAt(i) == now.charAt(y) && !temps[y]){
//                    count += 1;
//                    temps[y] = true;
//                }
//            }
//        }
//        if(count == n){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public static boolean isCounted(ArrayList<int[]> routes){
//        boolean flag = false;
//        for(int [] route : routes){
//            if(used[route[0]][route[1]] == 0){
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//    }
//    public static void find(String target, ArrayList<int[]> routes, String now){
//        if(now.length() == target.length()){
//            if(isPos(target, now){
//                routes.sort(new Comparator<int[]>(){
//                    @Override
//                    public int compare(int[] l1, int[] l2){
//                        if(l1[0] == l2[0]){
//                            return l1[1] - l2[1];
//                        }else{
//                            return l1[0] - l2[0];
//                        }
//                    }
//                });
//                if(!cheking.contains(routes)){
//                    cheking.add(routes);
//                    answer += 1;
//                    return;
//                }
//            }
//        }
//        for(int x=  0 ; x < )
//    }
//    public static int solution(String word, String [] cards){
//        n = word.length();
//        String [] target = word.split("");
//        used = new int [cards.length][cards.length];
//        boolean [] usedX = new boolean[cards.length];
//        boolean [] usedY = new boolean[cards.length];
//        for(int x = 0 ; x < cards.length; x++){
//            for(int y = 0; y < cards.length; y++){
//                if(contain(target,cards[x].charAt([y]))){
//                    usedX[x] = true;
//                    usedY[y] = true;
//                    ArrayList<int[]> route = new ArrayList<int[]>();
//                    route.add(new int[] {x,y});
//                    find(target,route, 1);
//                }
//            }
//        }
//        if(answer == 0){
//            return -1;
//        }
//    }
//    public static boolean contain(String target, char now){
//        for(int i= 0; i < target.length(); i++){
//            if(target.charAt(i) == now){
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        String word = "APPLE";
//        String [] cards = {"LLZKE", "LCXEA","CVPPS","EAVSR","FXPFP"};
//        System.out.println(solution(word, cards));
//    }
//}
