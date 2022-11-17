//    You are given a list of integers (both positive and negative). Find the continuous sequence of integers with the largest sum.
//        Write an algorithm to find the largest sum of the continuous sequence from the given list
//        Inou
//        The first line of input consists of an integer - InputArr size, representing the size of the list (N).
//        The next line consists of N space-separated integers representing the elements of the list.
//        Output
//        Print an integer representing the largest sum of the continuous sequence from the given list.
//        Example
//        Input
//        2 -8 3 -2 4 -10
//        Output.
//        Explanation:
//        The given list is (2, -8, 3, -2, 4,-10), and we take (3, -2, 4) as the continuous sequence for getting the largest sum. The sum is 3+ (-2) +4, Which
//        IS 5
//        So the outout is 5.

public class LargestSmallest {
    public static void main(String[] args) {
        int[] arr=new int[]{2, -8, 3, -2, 4,-10};
        int large=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<j+1;k++) sum+=arr[k];
                if(sum>large) large=sum;
                if(j==arr.length-1&&large<arr[j]) large=arr[j];
            }
        }
        System.out.println("Largest sum is "+large);
    }
}

