package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> ls = new ArrayList<>();

        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int j=0;
        for(List<Integer> row: triangle){
            ls.add(new ArrayList<>());
            for(int i =0;i<row.size();i++){
                if(row.size()==1){
                    ls.get(j).add(row.get(i));
                }else{
                    int num ;
                    if(i==row.size()-1){
                        num = row.get(i) + ls.get(j-1).get(i-1);
                    }else{
                        num = row.get(i) + Math.min(ls.get(j-1).get(Math.max(i-1,0)),
                                ls.get(j-1).get(i));
                    }

                    ls.get(j).add(num);
                }
            }
            j++;
        }

        int min = Integer.MAX_VALUE;
        for(int i: ls.get(ls.size()-1)){
            min = Math.min(i,min);
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(2));
        ls.add(Arrays.asList(3,4));
        ls.add(Arrays.asList(6,5,0));
        ls.add(Arrays.asList(4,1,8,3));
        int ans=   new Triangle().minimumTotal(ls);
        System.out.println(ans);
    }
}
