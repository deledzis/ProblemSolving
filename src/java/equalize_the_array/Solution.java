package java.equalize_the_array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Arrays.sort(arr);

        HashSet<Integer> arrAsSet = IntStream.range(0, arr.length)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
        int uniqueCount = arrAsSet.size();

        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i + 1] != arr[i]) {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
            if (maxCount > arr.length - i) break;
        }
        return uniqueCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}