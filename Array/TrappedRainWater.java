
public class TrappedRainWater {
    
    public static void CalculateRainWater(int array[])
    {
        int n = array.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = array[0];
        rightMax[n-1] = array[n-1];

        for(int i=1;i<n;i++)
        {
            leftMax[i] = Math.max(leftMax[i-1], array[i]);
            rightMax[n-i-1] = Math.max(rightMax[n-i], array[n-i-1]);
        }

        int amoutOfRain = 0;
        for(int i=0;i<array.length;i++)
        {
            int pillar = Math.min(leftMax[i],rightMax[i]);
            if(pillar - array[i] > 0)
            {
                amoutOfRain += pillar - array[i];
            }
        }
        System.out.println("Total amount of trapped water is: "+amoutOfRain);
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(leftMax[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(rightMax[i]+" ");
        // }
    }
    public static void main(String[] args)
    {
        // int array[] = {4,2,0,6,3,2,5};//11
        // int array[] = {5,1,1,1,5};//12
        // int array[] = {5,5,5,5,5,5,5};//12
        // int array[] = {5,4,3,2,1};//12
        int array[] = {1,2,3,4,5};//12
        CalculateRainWater(array);
    }
}