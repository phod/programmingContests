import java.math.BigInteger;

public class Fibonacci {

    private static BigInteger memo[];
    
    public static void main(String [] args) {
        int input = Integer.parseInt(args[0]) + 1;
        memo = new BigInteger[input];
        calculateFib(input);
        printFib(input);
    }

    public static void calculateFib(int fibNum) {
        memo[0] = BigInteger.valueOf(1);
        memo[1] = BigInteger.valueOf(1);
        for (int i = 2; i < fibNum; i++) {
            memo[i] = memo[i-1].add(memo[i-2]);
        }
    }

    public static void printFib(int fibNum) {
        for (int i = 0; i < memo.length; i++) {
            System.out.println(memo[i]);
        }
    } 
    
}
