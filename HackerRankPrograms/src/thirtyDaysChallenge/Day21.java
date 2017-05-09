package thirtyDaysChallenge;

import java.lang.reflect.Method;
import java.io.IOException;

public class Day21 {
	public static void main( String args[] )
    {
        Printer myPrinter=new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello","World"};
        myPrinter.printArray( intArray  );
        myPrinter.printArray( stringArray );
        int count=0;
		for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();
            if(name.equals("printArray"))
              count++;
        }
        
        if(count>1)System.out.println("Method overloading is not allowed!");
        assert count==1;

    } 
}

class Printer{
	void printArray(Object[] arr){
		for (Object object : arr) {
			System.out.println(object);
		}
	}
}
