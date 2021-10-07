package LV3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 매칭점수 {
    static class Score implements Comparable<Score>{
        int idx, outLinks,score;
        String title;
        double linkScore;
        Score(int a, int b, int c, String d){
            this.idx = a;
            this.outLinks = b;
            this.score = c;
            this.title = d;
            this.linkScore = 0;
        }

        public int compareTo(Score s){
            double one = this.score + this.linkScore;
            double two = s.score + s.linkScore;
            if(one == two){
                return this.idx - s.idx;
            }else{
                if(one > two){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }
    static class Result{
        int count;
        ArrayList<String> links;

        Result(int a, ArrayList<String> b){
            this.count = a;
            this.links = b;
        }

    }
    public static String getTitle(String page){
        String[] items = page.split("\n");
        items = items[3].split("content=\"https://");
        items = items[1].split(".com");
        return items[0];
    }
    public static int getScore(String page, String word){
        int score = 0;
        String[] items = page.split("\n");
        String [] now;
        for(int i = 5; i < items.length; i++){
            if(items[i].equals("</body>")){
                break;
            }else{
                if(items[i].contains("<a")){
                    continue;
                }else{
                    now = items[i].split(" ");
                    for(String n : now){
                        if(word.equalsIgnoreCase(n)){
                            score+=1;
                        }
                    }
                }
            }
        }
        return score;
    }
    public static Result getLink(String page){
        String[] items = page.split("\n");
        int count = 0;
        String[] target;
        ArrayList<String> links = new ArrayList<String>();
        for(int i = 0 ; i < items.length; i++){
            if(items[i].startsWith("<a")){
                count += 1;
                target = items[i].split(".com");
                target = target[0].split("https://");
                links.add(target[1]);
            }
        }
        return new Result(count, links);
    }
    public static int solution(String word, String [] pages){
        Map<String, Score> m2 = new LinkedHashMap<String, Score>();
        PriorityQueue<Score> pq = new PriorityQueue<Score>();
        Map<String, ArrayList<String>> m = new LinkedHashMap<String, ArrayList<String>>();
        Score[] answers = new Score[pages.length];
        for(int i = 0 ; i < pages.length; i++){
            String page = pages[i];
            String title = getTitle(page);
            int score = getScore(page,word);
            Result link = getLink(page);
            answers[i] = new Score(i,link.count,score, title);
            for(String target : link.links){
                if(m.containsKey(target)){
                    ArrayList<String> now = m.get(target);
                    now.add(title);
                    m.replace(target, now);
                }else{
                    ArrayList<String> now = new ArrayList<String>();
                    now.add(title);
                    m.put(target, now);
                }
            }
            m2.put(title, new Score(i,link.count, score, title));
        }
        for(int i = 0 ; i < pages.length; i++){
            String now = answers[i].title;
            double count = 0;
            for(String toGo : m.get(now)){
                Score s = m2.get(toGo);
                double temps = s.score;
                double temp2 = s.outLinks;
                double temp3 = temps / temp2;
                count += ((double)s.score / (double)s.outLinks);
            }
            Score S = m2.get(now);
            S.linkScore = count;
            m2.replace(now, S);
        }
        for(String key : m2.keySet()){
            pq.add(m2.get(key));
        }
        return pq.poll().idx;
    }
    public static void main(String[] args){
        String [] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        String word = "blind";
        System.out.println(solution(word, pages));
    }
}
