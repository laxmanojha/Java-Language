import java.util.*;

public class First {
    public static void printReverse(ArrayList<Integer>list) {
        for(int i = list.size()-1 ; i>=0;i--) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static void printMax(ArrayList<Integer>list) {
        int max = Integer.MIN_VALUE;
        for(int i = list.size()-1 ; i>=0;i--) {
            max = Math.max( max, list.get(i));
        }
        System.out.println("Max element is: "+max);
    }
    public static void swapNumber(ArrayList<Integer>list, int index1 , int index2) {
        System.out.println("Before Swapping: "+list);
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        System.out.println("After Swapping: "+list);
    }
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(8);
        list.add(4,5);
        // printReverse(list);
        // printMax(list);
        // swapNumber(list, 1, 03);
        // System.out.println(list);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // ArrayList<String>list2 = new ArrayList<>();
        // ArrayList<Boolean>list3 = new ArrayList<>();

        //Add method O(1)
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(1,10); //O(n)
        // System.out.println("List: "+list);

        //Get method O(1) 
        // System.out.println("Get element: "+list.get(4));

        //Set method O(n)
        // list.set(1, 5);
        // System.out.println("Set element: "+list);

        //Remove method O(n)
        // int a = list.remove(1);
        // System.out.println("removed element: "+list.remove(1));
        // System.out.println("List: "+list);

        //Contains element O(n)
        // System.out.println("Contains: "+list.contains(10));
        // System.out.println("Contains: "+list.contains(2));

        //Size method O(n)
        // System.out.println(list.size());
        // for(int i=0;i<list.size();i++) {
        //     System.out.print(list.get(i)+" ");
        // }
        // System.out.println();
    }
}