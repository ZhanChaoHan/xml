package com.jachs.sax.entity;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Dog {
	private String name;
	private String type;
	private String age;
	
	public Dog() {
		super();
	}

	public Dog(String name, String type, String age) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
