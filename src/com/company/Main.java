package com.company;
import collection.MyArray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrDemo();
    }

    public static void ArrDemo()
    {
        System.out.println("\t\t\tARRAY");
        System.out.println("push");
        MyArray<Integer> Arr1 = new MyArray<>(), Arr2 = new MyArray<>();
        for (int i = 0; i< 10; ++i)
        {
            Arr1.push(i);
            Arr2.push(0);
        }
        Arr1.print();
        Arr2.print();
        System.out.println("resize");
        for (int i = Arr1.size(), end = Arr1.size() + 10; i< end; ++i)
        {
            Arr1.push(i);
        }
        Arr1.print();
        System.out.println("Size arr1: " + Arr1.size());
        System.out.println("Capacity arr1: " + Arr1.capacity());
        System.out.println("pretend");
        Arr1.prepend(48);
        Arr1.print();
        System.out.println("insert");
        Arr1.insert(5, 125);
        Arr1.print();
        System.out.println("pop");
        for (int i = 0; i< 10; ++i)
        {
            System.out.println(Arr1.pop().toString() + "");
            Arr2.push(0);
        }
        Arr1.print();
        System.out.println("at 5-index: " + Arr1.at(5).toString());
        System.out.println("find " + Arr1.find(5));
        System.out.println("remove");
        Arr1.print();
        Arr1.remove(125);
        Arr1.print();
        System.out.println("delete");
        Arr1.print();
        Arr1.delete(5);
        Arr1.print();
    }
}
