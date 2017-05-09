package singleton;

public class SingletonTest implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonTest test = null;
		for (int i = 0; i < 5; i++) {
			test = new SingletonTest();
			Thread t = new Thread(test);
			t.setName(String.valueOf(i));
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Singleton.getInstance().setValue();
		System.out.println("Thread:"+ Thread.currentThread().getName()+":-->"+SingletonEnum.INSTANCE.getValue());
	}

}
