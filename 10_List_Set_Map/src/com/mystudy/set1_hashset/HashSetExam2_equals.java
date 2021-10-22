package com.mystudy.set1_hashset;

import java.util.HashSet;

class Person {
	String name; // 이름
	int age; // 나이
	String number; // 주민번호
	
	public Person(String name, int age, String number) {
		super();
		this.name = name;
		this.age = age;
		this.number = number;
	}
	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + ", number=" + number + "]";
	}
	@Override
	public int hashCode() {
//		System.out.println(">> HashCode() 실행");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
//		System.out.println(">> equals() 실행");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}

public class HashSetExam2_equals {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<>();
		Person p1 = new Person("홍길동", 27, "901010-1234567");
		Person p2 = new Person("홍길동", 27, "901010-1234567");
		System.out.println("p1.hashCode() : " + p1.hashCode());
		System.out.println("p2.hashCode() : " + p2.hashCode());
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		set.add(p1);
		set.add(p2);
		
		set.add(new Person("홍경래", 33, "901010-1234567"));
		
		set.add(new Person("김유신", 30, "881111-2222222"));
		set.add(new Person("홍길동", 27, "900202-3333333"));
		
		System.out.println(set);
	}
}
