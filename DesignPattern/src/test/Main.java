package test;

import singleton.SingletonEnum;

public class Main {
	public static void main(String[] args) {
			SingletonEnum sg = SingletonEnum.INSTANCE;
			System.out.println(sg.getValue());
	}

}
