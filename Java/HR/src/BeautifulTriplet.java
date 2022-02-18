import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulTriplet {
    public static int beautifulTriplets(int d, List<Integer> arr){
        int answer = 0;
        int n = arr.size();
        for(int i = 0;i  < n; i++){
            for(int j = 0;j < n; j++){
                if(i < j && arr.get(j) - arr.get(i) == d){
                    for(int q = j+1; q < n; q++){
                        if(arr.get(q) - arr.get(j) == d){
                            answer += 1;
                            break;
                        }else if(arr.get(q) - arr.get(j) > d){
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] temps = new int [] {1,2,4,5,7,8,10};
        List<Integer> arr = new ArrayList<Integer>();
        int d = 3;
        for(int temp : temps){
            arr.add(temp);
        }
        System.out.println(beautifulTriplets(d, arr));
    }
}
