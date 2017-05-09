package adapter;

public class PersonDataNew {
	private String name;
	private int age;
	Address address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}

class Address{
	int houseNum;
	String street;
	String city;
	
	public Address(int houseNum, String street, String city) {
		super();
		this.houseNum = houseNum;
		this.street = street;
		this.city = city;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [houseNum=" + houseNum + ", street=" + street + ", city=" + city + "]";
	}
	
	
	
}
