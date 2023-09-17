public class first {
    public static void firstCode(int[] arr, int index) {
        if(index == 5) {
            System.out.println();
            return;
        }
        arr[index] = index+1;
        System.out.print(arr[index]+" ");
        firstCode(arr, index+1);
        arr[index]-=2;
        System.out.print(arr[index]+" ");
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        firstCode(arr, 0);
    }
}