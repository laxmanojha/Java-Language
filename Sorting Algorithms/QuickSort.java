public class QuickSort {
    public static void quickSort(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }

        int pivotIndex = partition(arr, si, ei);

        quickSort(arr, si, pivotIndex-1);
        quickSort(arr, pivotIndex+1, ei);
    }
    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si;j<ei;j++) {
            if(arr[j]<= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = pivot;
        return i;
    }
    public static void main(String[] args) {
        // int[] arr = {1,1,2,0,0,2,1,0,2,1,0,2,0,1,0};
        int[] arr = {3,6,4,0,7,8,6,9};
        quickSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
