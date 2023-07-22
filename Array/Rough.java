import java.util.*;
public class Rough {
    public static Boolean samefrequency(int array[],int n,int max)
    {
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(max==array[i])
                count++;
        }
        if(count>=2)
            return true;
        else
            return false;
    }
    public static int weirdarray(int arr[], int n)
    {
        if(n==1)
            return 0;
        else
        {
            int array[]={0,1,2,3,4,5,6,7,8,9};
            for(int i=0;i<n;i++)
            {
                array[arr[i]-48]++;
            }
            int max=0;
            for(int i=0;i<10;i++)
            {
                if(max<array[i])
                    max=array[i];
            }
            if(samefrequency(array,10,max))
            {
                return 0;
            }
            else
            {
                
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println();
    }
}
