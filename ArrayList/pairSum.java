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
    
    public static boolean bruteForceSortedAndRotatedPairSum(ArrayList<Integer>list, int target) {
        for(int i=0;i<list.size();i++) {
            for(int j=i+1;j<list.size();j++) {
                if((list.get(i)+list.get(j))==target) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean optimizedSortedAndRotatedPairSum(ArrayList<Integer>list, int target) {
        int lp = 0;
        int rp = 0;
        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i)>list.get(i+1)) {
                rp = i+1;
                lp = i;
                break;
            }
        }
        // System.out.println(lp+" "+rp);
        while(lp != rp) {
            if(list.get(lp)+list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp)+list.get(rp) < target) {
                if(rp+1 == list.size()) {
                    rp = 0;
                }
                else {
                    rp++;
                }
            }
            else {
                if(lp-1 == -1) {
                    lp = list.size()-1;
                }
                else {
                    lp--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>(
            List.of(11,15,6,8,9,10)
        );
        // System.out.println("Pair sum exists: "+bruteForce(list, 12));
        // System.out.println("Pair sum exists: "+optimizedPairSum(list, 12));
        System.out.println("List: "+list);
        System.out.println("Pair sum exists: "+bruteForceSortedAndRotatedPairSum(list, 17));
        System.out.println("Pair sum exists: "+optimizedSortedAndRotatedPairSum(list, 17));



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