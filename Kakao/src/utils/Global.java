package utils;

import DTO.User;

import java.util.ArrayList;
import java.util.Map;

public class Global {
    private Map<Long, Long> grades;
    private ArrayList<User> waitings;


    public void setGrades(Map<Long, Long> a){
        this.grades = a;
    }
    public Map<Long, Long> getGrades(){
        return this.grades;
    }
    public void setWaitings(ArrayList<User> a){
        this.waitings = a;
    }
    public ArrayList<User> getWaitings(){
        return this.waitings;
    }
}
