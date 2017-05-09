package builder;

public class BuilderTest {

	public static void main(String[] args) {
		Person person = new Person.Builder("email", "password").age(10).city("Delhi").build();
	
		System.out.println(person);
	}
}
