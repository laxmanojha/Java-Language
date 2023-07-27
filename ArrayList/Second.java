import java.util.*;

public class Second {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>mainList = new ArrayList<>();
        for(int i=1;i<4;i++) {
            ArrayList<Integer>list = new ArrayList<>();
            int temp = i;
            for(int j=0;j<5;j++) {
                list.add(temp);
                temp+=i;
            }
            mainList.add(list);
        }

        System.out.println("Printing ArrayList of ArrayList:"+mainList);
        for(int i=0;i<mainList.size();i++) {
            // ArrayList<Integer>list = new ArrayList<>();
            // list = mainList.get(i);
            // ArrayList<Integer>list = new ArrayList<>(mainList.get(i));
            ArrayList<Integer>list = mainList.get(i);
            System.out.println("No. of ArrayList in ArrayList: "+i);
            for(int j=0;j<list.size();j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }
    }
}