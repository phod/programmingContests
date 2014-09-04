/*
    Calculates the nth fibonacci number, using the BigInteger class
    Copyright (C) 2014  phod

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

    private static BigInteger memo[];
    
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        boolean calculateSingle = false;
        if (scan.hasNextInt()) {
            if (args.length > 0 && args[0] == "-s") { //currently not working
                calculateSingle = true;
            }
            int input = scan.nextInt() + 1;
            memo = new BigInteger[input];
            if (calculateSingle) {
                findFib(input);
            } else {
                calculateFib(input);
                printFib(input);
            }
        } else {
            System.out.println("This program requires a single integer" +
                               " as input via stdin");
        }
    }

    public static void calculateFib(int fibNum) {
        memo[0] = BigInteger.valueOf(1);
        memo[1] = BigInteger.valueOf(1);
        for (int i = 2; i < fibNum; i++) {
            memo[i] = memo[i-1].add(memo[i-2]);
        }
    }

    public static BigInteger findFib(int fibNum) {
        return findFib(fibNum).add(findFib(fibNum));
    }

    public static void printFib(int fibNum) {
        for (int i = 0; i < memo.length; i++) {
            System.out.println(memo[i]);
        }
    } 
    
}
