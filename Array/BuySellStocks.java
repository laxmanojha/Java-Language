public class BuySellStocks {
    
    public static void bruteForce(int[] array) {
        int min = 0;
        int max = 0;
        int diff = 0;
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<array.length;j++)
            {
                if(array[j] - array [i] > diff)
                {
                    diff = array[j] - array[i];
                    min = array[i];
                    max = array[j];
                }
            }
        }
        System.out.println("Buy Stock at: "+min+"\nSell Stock at: "+max);
    }
    public static void optimizedSolution(int[] array) {
        int min = array[0];
        int max = 0;
        int diff = 0;
        for(int i=1;i<array.length;i++)
        {
            if(array[i] - min > diff)
            {
                diff = array[i] - min;
                max = array[i];
            }
            else if(array[i] - min < 0)
            {
                min = array[i];
            }
        }
        System.out.println("Buy Stock at: "+min+"\nSell Stock at: "+max);
    }
    public static void main(String[] args) {
        int array[] = {6,1,2,3,4,5,1};
        // int array[] = {7,1,5,3,6,4};
        bruteForce(array);
        optimizedSolution(array);
    }
}
