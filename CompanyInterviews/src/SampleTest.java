import java.util.*;

public class SampleTest
{
    public static void main(String[] args)
    {

    }

    public boolean testmethod(int age) {
        if(age<19)
        return true;
        else
            return false;
    }

    public int getLen(String s){
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
        }
        return size;

    }

    public int[] sortArray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

}