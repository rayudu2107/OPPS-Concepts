package list;

import java.util.ArrayList;

public class ListAndCollectionMethods {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add(100);
        l.add(200);
        l.add(300.0);
        l.add("java");
        l.add(100);
        System.out.println(l); // [100, 200, 300.0, java, 100]
        System.out.println("----list interface methods----");
        System.out.println(l.indexOf(300.0)); // 2
        System.out.println(l.lastIndexOf(100)); // 4
        System.out.println(l.get(3)); // java
        System.out.println(l); // [100, 200, 300.0, java, 100]
        l.add(0, 50);
        System.out.println(l); // [50, 100, 200, 300.0, java, 100]
        l.set(4, 250);
        System.out.println(l); // [50, 100, 200, 300.0, 250, 100]
        System.out.println("--------------collection methods-------------");
        ArrayList m = new ArrayList(l);
        m.add(300);
        System.out.println(m); // [50, 100, 200, 300.0, 250, 100, 300]
        System.out.println(m.contains(300)); // true
        System.out.println(m.contains("Java")); // false
        System.out.println(m.containsAll(l)); // true
        m.remove(0);
        System.out.println(l); // [50, 100, 200, 300.0, 250, 100]
        System.out.println(m.isEmpty()); // false
        m.clear();
        System.out.println(m); // []
        System.out.println(l.size()); // 6
        System.out.println(m.isEmpty()); // true
    }
}
