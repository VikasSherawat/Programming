package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class TimeMap {
    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        map.set("love","high",10);
        map.set("love","low",20);
        System.out.println(map.get("love",5));
        System.out.println(map.get("love",10));
        System.out.println(map.get("love",15));
        System.out.println(map.get("love",20));
        System.out.println(map.get("love",25));
    }
    Map<String, List<Pair>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,a->new ArrayList<>()).add(new Pair(value,timestamp));
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> list = map.get(key);
            int idx = binarySearch(list, timestamp);
            return list.get(idx).getKey();
        }

        return "";
    }

    private int binarySearch(List<Pair> list, int timestamp) {
        int lo = 0, hi = list.size()-1;
        while(lo<hi){
            int m = (lo+hi)/2;
            int val = list.get(m).getValue();
            if(val==timestamp){
                return m;
            }else if(val>timestamp){
                hi =m;
            }else{
                lo = m+1;
            }
        }
        return lo;
    }

    class Pair{
        String key;
        int value;

        public Pair(String key, int value){
            this.key = key;
            this.value = value;
        }

        public String getKey(){
            return this.key;
        }

        public int getValue(){
            return this.value;
        }
    }
}