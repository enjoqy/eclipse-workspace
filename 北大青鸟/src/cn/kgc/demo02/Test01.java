package cn.kgc.demo02;

import java.util.TreeSet;

public class Test01 {
	
	public static void main(String[] args) {
		TreeSet<Dog> treeSet = new TreeSet<>();
		treeSet.add(new Dog("dog"));
		System.out.println(treeSet);
		
		
		TreeSet<Cat> t = new TreeSet<>(new CatComparator());
		t.add(new Cat("cat"));
		System.out.println(t);
		
	}
}
