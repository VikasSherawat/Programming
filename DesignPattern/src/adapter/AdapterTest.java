package adapter;

public class AdapterTest {
	public static void main(String[] args) {
		String name = "Vikas";
		int age = 27;
		String address = "23,Chirag delhi,New Delhi";
		PersonDataOld old = new PersonDataOld(name, age, address);
		PersonAdapter obj = new PersonAdapter();
		if(obj.setData(old)){
			PersonDataNew person = obj.getPerson();
			System.out.println(person.getName()+":"+person.getAge());
			System.out.println(person.getAddress());
		}else{
			System.out.println("InCorrect Data");
		}
	}
}
