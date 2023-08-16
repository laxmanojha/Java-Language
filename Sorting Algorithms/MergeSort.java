public class MergeSort {
    public static void merge(int[]arr, int s, int e) {
        int mid = s+(e-s)/2;
        int len1 = mid-s+1;
        int len2 = e-mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        int index1 = 0;
        int index2 = 0;
        int mainArrayIndex = s;
        while(index1<len1) {
            arr1[index1++] = arr[mainArrayIndex++];
        }
        mainArrayIndex = mid+1;
        while(index2<len2) {
            arr2[index2++] = arr[mainArrayIndex++];
        }

        index1 = 0;
        index2 = 0;
        mainArrayIndex = s;
        while(index1<len1 && index2<len2) {
            if(arr1[index1] < arr2[index2]) {
                arr[mainArrayIndex++] = arr1[index1++];
            }
            else {
                arr[mainArrayIndex++] = arr2[index2++];
            }
        }
        while(index1<len1) {
            arr[mainArrayIndex++] = arr1[index1++];
        }
        while(index2<len2) {
            arr[mainArrayIndex++] = arr2[index2++];
        }
    }
    public static void mergeSort(int[] arr, int s, int e) {
        if(s>=e)
            return;
        
        int mid = s+(e-s)/2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);

        merge(arr, s, e);
    }
    public static void main(String[] args) {
        // int[] arr = {3,6,4,0,7,8,6,9};
        int[] arr = {1,1,2,0,0,2,1,0,2,1,0,2,0,1,0};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    } 
}
