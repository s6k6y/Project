package com.tcx;

import java.util.HashMap;
import java.util.Map;


public class Istrue {
    Map<Character,Integer> map = new HashMap<Character,Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);

        } };
    public int Method(String s){
        int end = 0;
        int n = s.length();
        for (int i = 0;i < n;i++){
            int value = map.get(s.charAt(i));
            if(i < n - 1 && map.get(s.charAt(i + 1)) < value){
                end -= value;
            }else{
                end += value;
            }

        }
        return end;
    }
}
