import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    static class Truck{
        int weight, position;


        Truck(int a, int b){
            this.weight = a;
            this.position = b;
        }
    }
    public static int solution(int bridge_length, int weight, int [] truck_weights){
        int answer = 0;
        int count = 0;
        Queue<Truck> q = new LinkedList<Truck>();
        while(true){
            if(count < truck_weights.length && truck_weights[count] <= weight && q.size() < bridge_length){
                q.add(new Truck(truck_weights[count], 0));
                weight -= truck_weights[count];
                count += 1;
            }
            int n = q.size();
            if(n == 0){
                break;
            }
            for(int i = 0 ; i < n; i++){
                Truck now = q.poll();
                if(now.position +1 < bridge_length){
                    q.add(new Truck(now.weight, now.position+1));
                }else{
                    weight += now.weight;
                }
            }
            answer += 1;
        }
        return answer+1;
    }
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int [] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));
        bridge_length = 100;
        weight = 100;
        truck_weights = new int [] {10};
        System.out.println(solution(bridge_length, weight, truck_weights));
        truck_weights = new int [] {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
