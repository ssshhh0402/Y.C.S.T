package Bagle;

import java.util.*;

public class Pro1 {
    public static String solution(String [] directory, String [] command){
        Map<String, Set<String>> m = new LinkedHashMap<String, Set<String>>();
        String [] inputs;
        for(String dir : directory){
            if(dir.equals("/")){
                Set<String> st = new LinkedHashSet<String>();
                m.put(dir,st);
                continue;
            }
            inputs = dir.split("/");
            if(inputs.length == 2){
                Set<String> set = m.get("/");
                Set<String> set2 = new LinkedHashSet<String>();
                set.add(inputs[1]);
                m.replace("/", set);
                m.put(inputs[1], set2);
            }else{
                String target = inputs[inputs.length-2];
                String now = inputs[inputs.length-1];
                Set<String> set = m.get(target);
                Set<String> set2 = new LinkedHashSet<String>();
                set.add(now);
                m.replace(target, set);
                m.put(now, set2);
            }
        }
        for(String com : command){
            inputs = com.split(" ");
            if(inputs[0].equals("mkdir")){
                inputs = inputs[1].split("/");
                int i = inputs.length-1;
                Set<String> now = m.get(inputs[i-1]);
                Set<String> st =  new LinkedHashSet<String>();
                now.add(inputs[i]);
                m.replace(inputs[i-1], now);
                m.put(inputs[i], st);
            }else if(inputs[0].equals("cp")){
                String[] sources = inputs[1].split("/");
                String[] dests = inputs[2].split("/");
                String source = sources[sources.length-1];
                String dest = dests[dests.length-1];
                Set<String> source_set = m.get(source);
                m.replace(dest, source_set);
            }else{
                String [] sources = inputs[1].split("/");
                String source = sources[sources.length-1];
                Set<String> targets = m.get(source);
                for(String target : targets){
                    m.remove(target);
                }
                m.remove(source);
            }
        }

        return "SET";
    }
    public static void main(String[] args){
        String [] directory = new String [] {"/", "/hello","/hello/tmp","/root","/root/abcd","/root/abcd/etc","/root/abcd/hello"};
        String [] command = new String [] {"mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello"};
        System.out.println(solution(directory, command));
        Map<String, Map> m = new LinkedHashMap<String, Map>();

    }
}
