import java.util.ArrayList;

public class First {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        // ArrayList<String>list2 = new ArrayList<>();
        // ArrayList<Boolean>list3 = new ArrayList<>();

        //Add method O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1,10); //O(n)
        // System.out.println("List: "+list);

        //Get method O(1) 
        // System.out.println("Get element: "+list.get(4));

        //Set method O(n)
        list.set(1, 5);
        // System.out.println("Set element: "+list);

        //Remove method O(n)
        // int a = list.remove(1);
        // System.out.println("removed element: "+list.remove(1));
        // System.out.println("List: "+list);

        //Contains element O(n)
        // System.out.println("Contains: "+list.contains(10));
        // System.out.println("Contains: "+list.contains(2));

        //Size method O(n)
        System.out.println(list.size());
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}