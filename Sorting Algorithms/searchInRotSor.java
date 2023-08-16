public class searchInRotSor {
    public static int searchInRotatedSortedArray(int[] arr, int target, int si, int ei) {
        if(si>=ei) {
            return -1;
        }

        int mid = si+(ei-si)/2;

        if(arr[mid] == target) {
            return mid;
        }

        if(arr[si] <= arr[mid]) {
            if(arr[si] <= target && target < arr[mid]) {
                return searchInRotatedSortedArray(arr, target, si, mid-1);
            }
            else {
                return searchInRotatedSortedArray(arr, target, mid+1, ei);
            }
        }
        else {
            if(arr[mid] < target && target <= arr[ei]) {
                return searchInRotatedSortedArray(arr, target, mid+1, ei);
            }
            else {
                return searchInRotatedSortedArray(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,7,8,1,2,3};
        System.out.println("Index : "+searchInRotatedSortedArray(arr, 0, 0, arr.length));
    }
}
