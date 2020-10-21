import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class BJ_4358 {
    public static void main(String[] args) throws IOException{
        int count = 0;
        Map<String, Integer> trees = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String tree = br.readLine();
            if (tree.equals("")){
                break;
            }else{
                if(trees.containsKey(tree)){
                    trees.put(tree,trees.get(tree) + 1);
                }else{
                    trees.put(tree,1);
                }
                count += 1;
            }
        }
        Object[] names = trees.keySet().toArray();
        Arrays.sort(names);
        for(Object name : names){
            String item = (String) name;
            Integer counts = trees.get(item);
            double per = (double)((counts * 100.0) / count);
            String answer = item + " " + String.format("%.4f", per) + "\n";
            System.out.println(answer);
        }
    }
}
