// import java.util.Scanner;
public class SubArray {
    
    public static void printSubArray(int array[])
    {
        int ts = 0;
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<=array.length;j++)
            {
                for(int k=i;k<j;k++)
                {
                    System.out.print(array[k]+" ");
                }
                System.out.println();
                ts++;
            }
            System.out.println();
        }
        System.out.println("Total number of subarrays are: "+ts);
    }
    public static void printSubArraySum(int array[])
    {
        int ts = 0;
        int subArraySum = 0;
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<=array.length;j++)
            {
                for(int k=i;k<j;k++)
                {
                    System.out.print(array[k]+" ");
                    subArraySum += array[k];
                }
                System.out.print("Total of subarray: "+subArraySum);
                System.out.println();
                subArraySum = 0;
                ts++;
            }
            System.out.println();
        }
        System.out.println("Total number of subarrays are: "+ts);
    }
    public static void printSubArrayMinMaxSum(int array[])
    {
        int ts = 0;
        int subArraySum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<=array.length;j++)
            {
                for(int k=i;k<j;k++)
                {
                    System.out.print(array[k]+" ");
                    subArraySum += array[k];
                }
                if(min > subArraySum)   min = subArraySum;
                if(max < subArraySum)   max = subArraySum;
                System.out.print("Total of subarray: "+subArraySum);
                System.out.println();
                subArraySum = 0;
                ts++;
            }
            System.out.println();
        }
        System.out.println("Maximum subarray sum is: "+max);
        System.out.println("Minimum subarray sum is: "+min);
        System.out.println("Total number of subarrays are: "+ts);
        System.out.println();
    }
    public static void printSubArrayMinMaxPrefixSum(int array[])
    {
        int ts = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prefix[] = new int[array.length];
        prefix[0] = array[0];
        for(int i=1;i<prefix.length;i++)
        {
            prefix[i] = prefix[i-1] + array[i];
        }
        for(int i=0;i<array.length;i++)
        {
            for(int j=i;j<array.length;j++)
            {
                int sum = (i==0) ? (prefix[j]) : (prefix[j]-prefix[i-1]);
                ts++;
                max = (max < sum) ? (sum) : (max);
                min = (min > sum) ? (sum) : (min);
            }
            System.out.println();
        }
        System.out.println("Maximum subarray sum is: "+max);
        System.out.println("Minimum subarray sum is: "+min);
        System.out.println("Total number of subarrays are: "+ts);
        System.out.println();
    }
    public static void printSubArrayMinMaxSumKadaneAlgorithm(int array[])
    {
        int ts = (array.length)*(array.length+1)/2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCurrSum = (array[0] > 0) ? array[0] : 0;
        max = (maxCurrSum > max) ? maxCurrSum : max;

        //If there is all the numbers are negative in array then we need to find the minimum sum by linear approach else it will return 0 as answer which will be wrong.
        int minCurrSum = (array[0] < 0) ? array[0] : 0;
        min = (minCurrSum < min) ? minCurrSum : min;
        for(int i=1;i<array.length;i++)
        {
            maxCurrSum = (maxCurrSum+array[i] > 0) ? (maxCurrSum+array[i]) : 0;
            max = (maxCurrSum > max) ? maxCurrSum : max;

            minCurrSum = (minCurrSum+array[i] < 0) ? (minCurrSum+array[i]) : 0;
            min = (minCurrSum < min) ? minCurrSum : min;
        }
        System.out.println("Maximum subarray sum is: "+max);
        System.out.println("Minimum subarray sum is: "+min);
        System.out.println("Total number of subarrays are: "+ts);
        System.out.println();
    }
    public static void main(String[] args) 
    {
        int array[] = {1,-2,4,6,-10};
        printSubArrayMinMaxPrefixSum(array);
        printSubArrayMinMaxSumKadaneAlgorithm(array);
    }
}
