package org.study.java8.chapter01;

public class Employee {
	private String ecode;
	private String sex;
	private String name;
	private int age;
	
	public Employee(String ecode, String sex, String name, int age) {
		super();
		this.ecode = ecode;
		this.sex = sex;
		this.name = name;
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

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

	@Override
	public String toString() {
		return "Employee [ecode=" + ecode + ", sex=" + sex + ", name=" + name
				+ ", age=" + age + "]";
	}
	
}
