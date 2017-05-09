package singleton;

public class Singleton {
	private static volatile Singleton instance;
	
	private int count;
	private Singleton() {
	}
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized (Singleton.class) {
				if(instance==null){
					instance = new Singleton();
					instance.count = 17;
				}
			}
		}
		return instance;
	}
	
	public void setValue(){
		instance.count++;
	}
	public int getCount(){
		return instance.count;
	}

}
