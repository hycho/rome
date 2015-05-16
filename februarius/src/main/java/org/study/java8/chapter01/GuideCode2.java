package org.study.java8.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuideCode2 {
	public static void main(String[] args) {
		List<Employee> department = Arrays.asList(
			new Employee("OXJ-M2311", "man", "Micheal Cho", 41),
			new Employee("OXJ-M2312", "woman", "Rucean Kim", 21),
			new Employee("OXJ-M2313", "man", "Jerry kan", 21),
			new Employee("OXJ-M2314", "woman", "arius li", 21)
		);
		
		List<Employee> mans = filterEmployee(department, GuideCode2::isSexMan);
		List<Employee> oldMans = filterEmployee(department, GuideCode2::isOldMan);
		
		System.out.println("Mans!!!");
		for(Employee em : mans) {
			System.out.println(em.toString());
		}
		
		System.out.println("Old Mans!!!");
		for(Employee em : oldMans) {
			System.out.println(em.toString());
		}
	}
	
	public interface Predicate<T> {	//java 8에서 제공하는 동일한 interface가 있지만 확인을 위해서 넣었음.
		boolean test(T o);
	}
	
	public static boolean isSexMan(Employee emp) {
		return "man".equals(emp.getSex());
	}
	
	public static boolean isOldMan(Employee emp) {
		return emp.getAge() > 40;
	}
	
	public static List<Employee> filterEmployee(List<Employee> department, 
												Predicate<Employee> p) { //메서드가 p라는 predicate파라메터로 전달.
		List<Employee> result = new ArrayList<Employee>();
		for(Employee emp : department) {
			if(p.test(emp)) {	//p(메소드기능)의 기능이 true인가? 즉 조건에 맞는가?
				result.add(emp);
			}
		}
		return result;
	}
}
