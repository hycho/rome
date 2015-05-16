package org.study.java8.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sun.security.acl.GroupImpl;
import static java.util.stream.Collectors.*;

public class GuideCode4 {
	public static void main(String[] args) {
		List<Employee> department = Arrays.asList(
			new Employee("OXJ-M2311", "man", "Micheal Cho", 41),
			new Employee("OXJ-M2312", "woman", "Rucean Kim", 71),
			new Employee("OXJ-M2313", "man", "Jerry kan", 21),
			new Employee("OXJ-M2314", "woman", "arius li", 51)
		);
		
//		Map<String, List<Employee>> oldBySexGroupMap = getOldBySexGroupMap(department);
//		Map<String, List<Employee>> oldBySexGroupMap = getOldBySexGroupMapStream(department);
//		
//		for(String key : oldBySexGroupMap.keySet()){
//            System.out.println(oldBySexGroupMap.get(key));
//        }
		
		List<Employee> oldEmployee = getOldParallel(department);
		
		for(Employee emp : oldEmployee){
            System.out.println(emp);
        }
	}
	
	// 나이 40살 이상인 성별 그룹을 구하는 로직
	public static Map<String, List<Employee>> getOldBySexGroupMap(List<Employee> department) { 
		Map<String, List<Employee>> oldSexGroupMap = new HashMap<String, List<Employee>>();
		for(Employee emp : department) {
			if(emp.getAge() > 40) {
				List<Employee> oldSexGroup = oldSexGroupMap.get(emp.getSex());
				if(oldSexGroup == null) {
					oldSexGroup = new ArrayList<Employee>();
					oldSexGroupMap.put(emp.getSex(), oldSexGroup);
				}
				oldSexGroup.add(emp);
			}
		}
		return oldSexGroupMap;
	}
	
	// Stream을 사용해서 나이 40살 이상인 성별 그룹을 구하는 로직
	public static Map<String, List<Employee>> getOldBySexGroupMapStream(List<Employee> department) {
		return department.stream()
					.filter((Employee emp) -> emp.getAge() > 40)
					.collect(groupingBy(Employee::getSex));
	}
	
	public static List<Employee> getOld(List<Employee> department) {
		return department.stream()
				.filter((Employee emp) -> emp.getAge() > 40)
				.collect(toList());
	}
	
	public static List<Employee> getOldParallel(List<Employee> department) {
		return department.parallelStream()
				.filter((Employee emp) -> emp.getAge() > 40)
				.collect(toList());
	}
}
