package java.staircase;

import java.util.Scanner;

public class Solution {

    // Complete the java.staircase function below.
    static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            String line = new String(new char[n - i - 1]).replace('\0', ' ') + new String(new char[i + 1]).replace('\0', '#');
            System.out.println(line);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

