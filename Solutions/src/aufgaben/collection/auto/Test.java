package aufgaben.collection.auto;

import java.util.*;

public class Test {

	public static void main(String[] args) {

		Auto a1 = new BMW("X1", 2016) ;
		Auto a2 = new BMW("X5", 2017) ;
		Auto a3  = new VW("Q1",  2015);
		Auto a4  = new VW("Q5",  2016);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		LinkedList<Auto> list = new LinkedList<Auto>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		
		System.out.println(a2.hashCode());
		System.out.println(list);
		//print(list);
		
		HashSet<Auto> hs = new HashSet<Auto>(list);
		System.out.println(hs);
		//print(hs);
	}
}
