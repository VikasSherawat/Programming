package singleton;

public enum SingletonEnum {
	INSTANCE;
	
	private int count ;
	private SingletonEnum(){
		count = 17;
	}
	
	public int getValue(){
		return count;
	}
	
}
