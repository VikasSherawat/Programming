package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinTimeDifference {
    public static void main(String[] args) {
        List<String> s = Arrays.asList("21:19","10:00","20:19","10:01");
        int ans = new MinTimeDifference().findMinDifference(s);
        System.out.println(ans);
    }
    public int findMinDifference(List<String> times) {
        int min =1440;
        List<Integer> minutes = times.stream().map(this::getInMin).sorted().collect(Collectors.toList());
        for(int i =0;i<minutes.size();i++){
            if(i == 0){
                int a = Math.abs(minutes.get(i)-minutes.get(minutes.size()-1));
                int b = 1440+minutes.get(i)-minutes.get(minutes.size()-1);
                int lmin = Math.min(a, b);
                min = Math.min(min, lmin);
            }else{
                int lmin = minutes.get(i)-minutes.get(i-1);
                min = Math.min(min, lmin);
            }
        }
        return min;
    }

    private int getInMin(String time){
        String hour = time.split(":")[0], min = time.split(":")[1];
        return Integer.parseInt(hour) * 60 + Integer.parseInt(min);
    }
}
