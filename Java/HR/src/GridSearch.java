import java.util.ArrayList;
import java.util.List;

public class GridSearch {
    static int gn, gm, pn, pm;
    public static boolean confirm(List<String> G, List<String> P, int in, int im){
        for(int n= 0; n < pn; n++){
            String g = G.get(in+n);
            String p = P.get(n);
            for(int m = 0; m < pm; m++){
                if(g.charAt(im+m) != p.charAt(m)){
                    return false;
                }
            }
        }
        return true;
    }
    public static String gridSearch(List<String> G, List<String> P){
        boolean flag = false;
        gn = G.size();
        gm = G.get(0).length();
        pn = P.size();
        pm = P.get(0).length();
        char start = P.get(0).charAt(0);
        for(int n = 0; n < gn-pn; n++){
            String row = G.get(n);
            for(int m = 0; m <= gm-pm; m++){
                if(row.charAt(m) == start){
                    flag  = confirm(G, P, n,m);
                    if(flag){
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }
        if(flag){
            return "Yes";
        }else{
            return "No";
        }
    }
    public static void main(String[] args){
//        String [] g = new String [] {"7283455864",
//                "6731158619",
//                "8988242643",
//                "3830589324",
//                "2229505813",
//                "5633845374",
//                "6473530293",
//                "7053106601",
//                "0834282956",
//                "4607924137"
//        };
//        String [] p = new String [] {"9505",
//                "3845",
//                "3530"
//        };
        String [] g = new String [] {"123412",
        "561212",
        "123634",
        "781288"
        };
        String [] p = new String [] {
                "12",
                "34"
        };
        List<String> G = new ArrayList<String>();
        List<String> P = new ArrayList<String>();
        for(String gg: g){
            G.add(gg);
        }
        for(String pp : p){
            P.add(pp);
        }
        System.out.println(gridSearch(G, P));
    }
}
