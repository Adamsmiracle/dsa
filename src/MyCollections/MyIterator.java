package MyCollections;

import java.util.*;

public class MyIterator {
   static List<String> list = new  ArrayList<>();
   static Set<Integer> set = new HashSet();

    public static void main(String[] args){
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");



        set.add(234);
        set.add(22);
        set.add(45);
        set.add(33);

        Iterator<Integer> setIterator = set.iterator();

        Iterator<String> iterator = list.iterator();


        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("\n");
//        Set iterator does not guarantee order
        setIterator.forEachRemaining((e) -> System.out.println(e));

//        while(setIterator.hasNext()){
////            System.out.println(setIterator.next());
//            setIterator.forEachRemaining((e) -> System.out.println("it is remaining"));
//        }

    }
}
