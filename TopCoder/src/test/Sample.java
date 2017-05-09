package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by vikas on 9/5/17.
 */
public class Sample {
    public static void main(String[] args){
        Integer a = 126;
        Integer b = 125;
        b++;

        double db=1.5d;
        double c=3/2.0;
        System.out.println(db==c);
    }
}

class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o!=null &&
                o instanceof Person &&
                //((Person)o).id ==id &&
                ((Person)o).name.equals(name);
    }
}
