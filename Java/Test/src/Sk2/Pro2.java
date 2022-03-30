package Sk2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Pro2 {
    public static class Work implements Comparable<Work>{
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
        @Override
        public int compareTo(Work w){
            return this.Stime - w.Stime;
        }
    }
    public static String[] solution(String[] arr, String[] processes){
        ArrayList<String> result = new ArrayList<String>();
        PriorityQueue<Work> ReadWaiting = new PriorityQueue<Work>();                //read = 0, write = 1;
        PriorityQueue<Work> WriteWaiting = new PriorityQueue<Work>();
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
        int startTime = 0, endTime = 1, nowType = -1, time = 0;
        String data;
        Work now;
        while(!ReadWaiting.isEmpty() || !WriteWaiting.isEmpty()){
            if(ReadWaiting.isEmpty()){
                now = WriteWaiting.poll();
            }else if(WriteWaiting.isEmpty()){
                now = ReadWaiting.poll();
            }else{
                int readWaiting = ReadWaiting.peek().Stime, writeWaiting = WriteWaiting.peek().Stime;
                if(nowType == 0){
                    if(readWaiting < endTime && writeWaiting < endTime){
                        now = writeWaiting >= readWaiting ? ReadWaiting.poll() : WriteWaiting.poll();
                    }else if(readWaiting < endTime){
                        now = ReadWaiting.poll();
                    }else if(writeWaiting < endTime){
                        now = WriteWaiting.poll();
                    }else{
                        now = writeWaiting <= readWaiting ? WriteWaiting.poll() : ReadWaiting.poll();
                    }
                }else{
                    if(writeWaiting <= endTime){
                        now = WriteWaiting.poll();
                    }else if(readWaiting < endTime){
                        now = ReadWaiting.poll();
                    }else{
                        now = readWaiting >= writeWaiting ? WriteWaiting.poll() : ReadWaiting.poll();
                    }
                }
            }
            if(now.type == 0){
                if(nowType == 0){
                    int nowEndTime = startTime+now.Tcost;
                    if(nowEndTime > endTime){
                        time += (nowEndTime - endTime);
                        endTime = nowEndTime;
                    }
                }else{
                    time += now.Tcost;
                    nowType = now.type;
                    startTime = endTime;
                    endTime = endTime + now.Tcost-1;
                }
                data = "";
                for(int i = now.Sindex; i <= now.Eindex; i++){
                    data += arr[i];
                }
                result.add(data);
            }else{
                nowType = now.type;
                time += now.Tcost;
                startTime = endTime;
                endTime += now.Tcost;
                for(int i = now.Sindex; i <= now.Eindex; i++){
                    arr[i] = now.target;
                }
            }
        }
        int n = result.size();
        String [] answer = new String [n+1];
        for(int i = 0; i <n ;i++){
            answer[i] = result.get(i);
        }
        answer[n] = String.valueOf(time);
        return answer;
    }
    public static void main(String[] args){
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
