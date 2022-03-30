package Sk2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro2_2 {
    public static class Work{
        int type, Stime, Tcost, Sindex, Eindex;
        String target;
        Work(int type, int sTime, int tCost, int sIndex, int eIndex, String target ){
            this.type = type;
            this.Stime = sTime;
            this.Tcost = tCost;
            this.Sindex = sIndex;
            this.Eindex = eIndex;
            this.target = target;
        }
    }
    public static String [] solution(String[] arr, String [] processes){
        ArrayList<String> results = new ArrayList<String>();
        Queue<Work> ReadWaiting = new LinkedList<Work>();
        Queue<Work> WriteWaiting = new LinkedList<Work>();
        String target;
        int type;
        for(String process : processes){
            String [] datas = process.split(" ");
            target = "";
            int sTime = Integer.parseInt(datas[1]), cost = Integer.parseInt(datas[2]), sIndex = Integer.parseInt(datas[3]), eIndex = Integer.parseInt(datas[4]);
            if (datas[0].equals("read")) {
                type = 0;
                ReadWaiting.add(new Work(type, sTime, cost, sIndex, eIndex, target));
            }else{
                type = 1;
                target = datas[5];
                WriteWaiting.add(new Work(type, sTime, cost, sIndex, eIndex, target));
            }
        }
        int endTime = 1, nowType = -1, time = 0;
        String data;
        Work now;
        int writeWaiting, readWaiting;
        while(!ReadWaiting.isEmpty() || !WriteWaiting.isEmpty()){
            if(ReadWaiting.isEmpty()){
                now = WriteWaiting.poll();
            }else if(WriteWaiting.isEmpty()){
                now = ReadWaiting.poll();
            }else {
                if (nowType == -1) {
                    readWaiting = ReadWaiting.peek().Stime;
                    writeWaiting = WriteWaiting.peek().Stime;
                    if (readWaiting < writeWaiting) {
                        now = ReadWaiting.poll();
                        endTime = now.Stime + now.Tcost;
                        nowType = now.type;
                        time = now.Tcost;
                    } else {
                        now = WriteWaiting.poll();
                        endTime = now.Stime + now.Tcost;
                        nowType = now.type;
                        time = now.Tcost;
                    }
                    continue;
                } else if (nowType == 0) {
                    readWaiting = ReadWaiting.peek().Stime;
                    writeWaiting = WriteWaiting.peek().Stime;
                    if(readWaiting < endTime){
                        now = ReadWaiting.poll();
                    }else if(writeWaiting < endTime){
                        now = WriteWaiting.poll();
                    }else if(writeWaiting == endTime && readWaiting == endTime){
                        now = WriteWaiting.poll();
                    }else{
                        now = readWaiting > writeWaiting ? WriteWaiting.poll() : ReadWaiting.poll();
                    }
                } else {
                    readWaiting = ReadWaiting.peek().Stime;
                    writeWaiting = WriteWaiting.peek().Stime;
                    if(writeWaiting <= endTime){
                        now = WriteWaiting.poll();
                    }else if(readWaiting <= endTime){
                        now = ReadWaiting.poll();
                    }else{
                        now = readWaiting > writeWaiting? WriteWaiting.poll() : ReadWaiting.poll();
                    }
                }
            }
            if(nowType == 0){
                if(now.type == 0){
                    time += now.Tcost;
                    endTime += now.Tcost;
                }else{
                    time += now.Tcost;
                    endTime += now.Tcost;
                    nowType = now.type;
                }
                //여기다가 그 읽는 매커니즘
                String result = "";
                for(int i = now.Sindex; i <= now.Eindex; i++){
                    result += arr[i];
                }
                results.add(result);
            }else{
                time += now.Tcost;
                endTime += now.Tcost;
                nowType = now.type;
                //여기다가 쓰는 매커니즘
                for(int i = now.Sindex; i <= now.Eindex; i++){
                    arr[i] = now.target;
                }
            }
        }
        int m = results.size();
        String [] answer = new String[m+1];
        for(int i = 0; i < m; i++){
            answer[i] = results.get(i);
        }
        answer[m] = String.valueOf(time);
        return answer;
    }
    public static void main(String [] args){
        String [] arr = new String [] {"1","2","4","3","3","4","1","5"};
        String [] process = new String [] {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
//        arr = new String [] {"1","1","1","1","1","1","1"};
//        process = new String [] {"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"};
        String [] answers=  solution(arr, process);
        for(String answer : answers){
            System.out.println(answer);
        }
        arr = new String [] {"1","1","1","1","1","1","1"};
        process = new String [] {"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"};
        System.out.println("-------");
        answers = solution(arr, process);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
