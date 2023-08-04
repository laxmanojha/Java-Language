import java.util.*;
public class maxAreaInHistogram {
    public static int optimizedMaxArea(int[] arr) { //O(n)
        Stack<Integer> s = new Stack<>();
        int nsr[] = new int[arr.length];
        //next smaller right
        for(int i=arr.length-1;i>=0;i--) { //O(n)
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            }
            else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller left
        s = new Stack<>();
        int nsl[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) { //O(n)
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //maxarea
        //height = arr[i]
        //width = nsr[i] - nsl[i] -1 --> j-i-1
        int maxArea = 0;
        for(int i=0;i<arr.length;i++) { //O(n)
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height*width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public static int bruteForce(int[] arr) { // O(n^2)
        // int ans[] = new int[arr.length];
        int max_area = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
                int area = 0;
                for(int j=i;j<arr.length;j++) {
                    if(arr[i] <= arr[j]) {
                        area += arr[i];
                    }
                    else {
                        break;
                    }

                }
                for(int j=i-1;j>=0;j--) {
                    if(arr[j] >= arr[i])
                        area += arr[i];
                    else 
                        break;
                }
                if(max_area < area)
                    max_area = area;
        }
        return max_area;
    }
    public static void main(String[] args) {
        // int arr[] = {2,1,5,6,2,3};
        int arr[] = {2,4};
        // int arr[] = {1,4,8,6,12,10,7,3}; // 8 24 8 30 12 20 21 21
        // int ans[] = bruteForce(arr);
        // for(int i=0;i<ans.length;i++) {
        //     System.out.print(ans[i]+" ");
        // }
        System.out.println(bruteForce(arr));
        System.out.println(optimizedMaxArea(arr));
    }
}