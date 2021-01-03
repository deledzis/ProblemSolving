package java.repeated_string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char[] arr = s.toCharArray();
        Stream<Character> cStream = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);

        long l = cStream.filter(c -> c == 'a').count();
        long sl = s.length();
        long fullParts = n / sl;
        long trailing = n - (fullParts * sl);

        Stream<Character> trailingStream = LongStream.range(0, trailing).mapToObj(i -> arr[(int) i]);
        long tl = trailingStream.filter(c -> c == 'a').count();

        return l * fullParts + tl;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println("res = " + result);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
