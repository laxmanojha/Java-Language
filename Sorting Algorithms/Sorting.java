import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static void SelectionSort(ArrayList<Integer>arr) {
        for(int i=0;i<arr.size();i++) {
            int minIndex = i;
            for(int j=i+1;j<arr.size();j++) {
                if(arr.get(j)<arr.get(minIndex))
                    minIndex = j;
            }
            Collections.swap(arr, i, minIndex);
        }
        // System.out.println(arr);
    }
    public static void SelectionSort(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            int minIndex = i;
            int temp = arr[minIndex];
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[minIndex])
                    minIndex = j;
            }
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void BubbleSort(ArrayList<Integer>list) {
        boolean swapped = true;
        int n=list.size();
        for(int i=1;i<n;i++) {
            for(int j=0;j<n-i;j++) {
                if(list.get(j) > list.get(j+1)) {
                    Collections.swap(list, j, j+1);
                    swapped = false;
                }
            }
            if(swapped) break;
        }
    }
    public static void InsertionSort(ArrayList<Integer> list) {
        for(int i=1;i<list.size();i++) {
            int temp = list.get(i);
            int j=i-1;
            for(;j>=0;j--) {
                if(list.get(j)>temp) {
                    list.set(j+1, list.get(j));
                }
                else {
                    break;
                }
            }
            list.set(j+1, temp);
        }
    }
    public static void CountingSort(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(int i:list) {
            if(max<i)   
                max=i;
        }
        int[] arr = new int[max+1];
        for(int i: list) {
            arr[i]++;
        }
        int j=0;
        for(int i=0;i<arr.length;i++) {
            while(arr[i]!=0) {
                list.set(j++, i);
                arr[i]--;
            }
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(){
            {
                add(7);add(5);add(4);add(7);add(4);
                add(2);add(1);add(2);add(7);add(4);
                add(6);add(1);add(2);add(3);add(3);
            }
        };
        System.out.println(arr);
        CountingSort(arr);
        
        /* SORTING ALGO's

        InsertionSort(arr);
        System.out.println(arr);

        SelectionSort(arr);
        BubbleSort(arr);
        // int[] array = {2,5,6,9,0};

        for(int i:array){   System.out.print(i+" ");}
        System.out.println();
        SelectionSort(array);
        for(int i:array){   System.out.print(i+" ");}
        System.out.println();*/
    }
}