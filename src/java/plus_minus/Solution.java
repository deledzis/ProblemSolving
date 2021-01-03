package java.plus_minus;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double pos = ((double) Arrays.stream(arr).filter(i -> i > 0).count()) / arr.length;
        double neg = ((double) Arrays.stream(arr).filter(i -> i < 0).count()) / arr.length;
        double zero = ((double) Arrays.stream(arr).filter(i -> i == 0).count()) / arr.length;
        System.out.println(String.format("%.6f", pos));
        System.out.println(String.format("%.6f", neg));
        System.out.println(String.format("%.6f", zero));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
