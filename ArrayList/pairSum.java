import java.util.*;

public class pairSum {

    public static boolean bruteForce(ArrayList<Integer>list,int target) {
        for(int i=0;i<list.size();i++) {
            for(int j=i+1;j<list.size();j++) {
                if((list.get(i)+list.get(j))==target) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean optimizedPairSum(ArrayList<Integer>list, int target) {
        int lp = 0;
        int rp = list.size()-1;
        while(lp<rp) {
            if((list.get(lp)+list.get(rp)) == target) {
                return true;
            }
            else if((list.get(lp)+list.get(rp)) < target) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>(
            List.of(1,2,4,5,6)
        );
        list.add(2,3);
        System.out.println("Pair sum exists: "+bruteForce(list, 12));
        System.out.println("Pair sum exists: "+optimizedPairSum(list, 12));



        // ArrayList<Integer>list2 = new ArrayList<>(
        //     Arrays.asList(1,2,3,4,5,6)
        // );
        // ArrayList<Integer>list2 = new ArrayList<>(){
        //     {
        //         add(1);
        //         add(2);
        //         add(3);
        //     }
        // };
        // System.out.println(list+"\n"+list2);
    }
}