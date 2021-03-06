import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer,Integer> map;
    List<Integer> idx;
    public RandomizedSet() {
        map = new HashMap<>();
        idx = new ArrayList<>();
    }

    public static void main(String[] args) {
         //* Your RandomizedSet object will be instantiated and called as such:
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(0);
        param_1 = obj.insert(1);
        boolean param_2 = obj.remove(0);
        param_1 = obj.insert(1);
        param_2 = obj.remove(1);
        int param_3 = obj.getRandom();
        System.out.println(param_3);

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val, idx.size());
        idx.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int index = map.get(val);
        if(index < idx.size()-1){
            int lastVal = idx.get(idx.size()-1);
            idx.set(index, lastVal);
        }

        map.remove(val);
        idx.remove(idx.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int x = new Random().nextInt(idx.size());
        return idx.get(x);
    }
}