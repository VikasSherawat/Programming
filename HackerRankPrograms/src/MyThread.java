
import java.util.LinkedList;

public class MyThread {
	public static void main(String[] args) {
		
	}

}


enum Level {
	HIGH  (3),  //calls constructor with value 3
    MEDIUM(2),  //calls constructor with value 2
    LOW   (1)   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private final int levelCode;

    private Level(int levelCode) {
        this.levelCode = levelCode;
    }
    
    public int getLevel(){
    	return this.levelCode;
    }
}