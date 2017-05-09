package adapter;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PersonAdapter {
	
	PersonDataNew person;
	
	public boolean setData(PersonDataOld old) {
		String name = old.getName();
		int age = old.getAge();
		String[] add = old.getAddress().split(",");
		int houseNum = 0;
		try {
			houseNum = Integer.valueOf(add[0]);
		} catch (NumberFormatException e) {
			System.out.println("Exception Occured " + e.getMessage());
			return false;
		}
		String street = add[1];
		String city = add[2];
		Address address = new Address(houseNum, street, city);
		boolean success = setDataNew(name, age, address);
		return success;
	}

	private boolean setDataNew(String name, int age, Address address) {
		// TODO Auto-generated method stub
		boolean ans = true;
		PersonDataNew newData = new PersonDataNew();
		newData.setName(name);
		newData.setAge(age);
		newData.setAddress(address);
		this.person = newData;
		return ans;
	}

	public PersonDataNew getPerson() {
		return person;
	}

	public void setPerson(PersonDataNew person) {
		this.person = person;
	}
	
	
}
