package builder;

public class Person {
	
	private final String email;
	private final String password;
	private final int age;
	private final String city;
	private final String country;
	
	private Person(Builder builder) {
		// TODO Auto-generated constructor stub
		this.email = builder.email;
		this.password = builder.password;
		this.age = builder.age;
		this.city = builder.city;
		this.country = builder.country;
	}
	
	public String toString(){
		return this.email+","+this.city;
	}
	
	
	public static class Builder{
		private final String email;
		private final String password;
		private int age;
		private String city;
		private String country;
		
		public Builder(String email, String password){
			this.email = email;
			this.password = password;
		}
		
		public Builder age(int val){
			age = val;
			return this;
		}
		
		public Builder city(String val){
			city = val;
			return this;
		}
		
		public Builder age(String val){
			country = val;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}
	
}
