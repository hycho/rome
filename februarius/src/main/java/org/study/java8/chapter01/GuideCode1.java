package org.study.java8.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuideCode1 {
	public static void main(String[] args) {
		List<Employee> department = Arrays.asList(
			new Employee("OXJ-M2311", "man", "Micheal Cho", 41),
			new Employee("OXJ-M2312", "woman", "Rucean Kim", 21),
			new Employee("OXJ-M2313", "man", "Jerry kan", 21),
			new Employee("OXJ-M2314", "woman", "arius li", 21)
		);
				
		List<Employee> mans = getMans(department);
		List<Employee> oldMans = getOldMan(department);
		
		System.out.println("Mans!!!");
		for(Employee em : mans) {
			System.out.println(em.toString());
		}
		
		System.out.println("Old Mans!!!");
		for(Employee em : oldMans) {
			System.out.println(em.toString());
		}
	}
	
	public static List<Employee> getMans(List<Employee> department) {
		List<Employee> mans = new ArrayList<Employee>();
		for(Employee emp : department) {
			if(emp.getSex().equals("man")) {
				mans.add(emp);
			}
		}
		return mans;
	}
	
	public static List<Employee> getOldMan(List<Employee> department) {
		List<Employee> mans = new ArrayList<Employee>();
		for(Employee emp : department) {
			if(emp.getAge() > 40) {
				mans.add(emp);
			}
		}
		return mans;
	}

}
