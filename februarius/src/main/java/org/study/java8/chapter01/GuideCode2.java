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
	
	public interface Predicate<T> {	//java 8���� �����ϴ� ������ interface�� ������ Ȯ���� ���ؼ� �־���.
		boolean test(T o);
	}
	
	public static boolean isSexMan(Employee emp) {
		return "man".equals(emp.getSex());
	}
	
	public static boolean isOldMan(Employee emp) {
		return emp.getAge() > 40;
	}
	
	public static List<Employee> filterEmployee(List<Employee> department, 
												Predicate<Employee> p) { //�޼��尡 p��� predicate�Ķ���ͷ� ����.
		List<Employee> result = new ArrayList<Employee>();
		for(Employee emp : department) {
			if(p.test(emp)) {	//p(�޼ҵ���)�� ����� true�ΰ�? �� ���ǿ� �´°�?
				result.add(emp);
			}
		}
		return result;
	}
}
