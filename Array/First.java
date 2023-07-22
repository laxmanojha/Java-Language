import java.util.Scanner;

public class First {
    
    public static String searchInput(String canteen[], String input) {
        for(int i=0;i<canteen.length;i++) {
            if(canteen[i].toLowerCase().equals(input.toLowerCase())) {
                return "Input Found";
            }
            else {
                continue;
            }
        }
        return "Input not Found";
    }
    public static void BinarySearch(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;
        int mid = start+(end-start)/2;
        while(start<=end) {
            if(numbers[mid] == key) {
                System.out.println("Key found at index: "+mid);
                return;
            }
            else if(numbers[mid] > key) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
            mid = start+(end-start)/2;
        }
        System.out.println("Key not Found.");
    }
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter size: ");
        int size = sc.nextInt();
        int numbers[] = new int[size];
        for(int i=0;i<size;i++)
        {
            System.out.println("Enter number:");
            numbers[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        BinarySearch(numbers,key);
        // String canteen[] = {"Patties","Burger","Samosa","Drink"};
        // String input = sc.nextLine();
        // System.out.println(searchInput(canteen, input));
    }
}
