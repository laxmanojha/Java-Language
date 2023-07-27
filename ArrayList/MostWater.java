import java.util.*;

public class MostWater {
    public static void mostContainWaterCapacity(ArrayList<Integer>list) {
        int left = 0;
        int right = 0;
        int maxCapacity = Integer.MIN_VALUE;
        for(int i=0;i<list.size()-1;i++) {
            for(int j=i+1;j<list.size();j++) {
                int minNumber = Math.min(list.get(i),list.get(j));
                if( maxCapacity < ( minNumber * (j-i) ) ) {
                    maxCapacity = minNumber * (j-i);
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println("Max Capacity is: "+ maxCapacity);
        System.out.println("Max capacity indices are: "+left+" "+right);
    }
    public static void twoPointerApproach(ArrayList<Integer>list) {
        int left = 0;
        int right = list.size()-1;
        int maxCapacity = 0;
        while(left<right) {
            int height = Math.min(list.get(left),list.get(right));
            int width = right - left;
            int area = height * width;
            maxCapacity = area > maxCapacity ? area : maxCapacity;
            if(list.get(left) < list.get(right)) {
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println("Max Capacity is: "+maxCapacity);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>list = new ArrayList<>();
        int Size = sc.nextInt();
        for(int i=0;i<Size;i++) {
            list.add(sc.nextInt());
        }
        System.out.println(list);
        mostContainWaterCapacity(list);
        twoPointerApproach(list);
    }
}