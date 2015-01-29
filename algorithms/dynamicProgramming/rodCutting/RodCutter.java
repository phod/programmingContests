import java.util.Scanner;

public class RodCutter {

    public static int findMax(int size, int[] values) {
        int[] temp = new int[size+1];
        int currLargest;
        temp[0] = 0;
        for (int j = 0; j <= size; j++) {
            currLargest = -1;
            for (int i = 0; i <= j; i++) {
                currLargest = Math.max(currLargest, values[i] +
                                       temp[j-i]);
            }
            temp[j] = currLargest;
        }
        return temp[size];
    }
    
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] values = new int[length+1];
        values[0] = 0;
        for (int i = 1; i <= length; i++) {
            values[i] = scan.nextInt();
        }
        int ans = findMax(length, values);
        System.out.println(ans);
    }
    
}
