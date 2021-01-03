package java.tinkoff_fintech.test.b;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * На стандартном потоке ввода задаётся последовательность целых чисел.
 *
 * Каждое число последовательности не меньше -20000000 и не больше 20000000.
 *
 * Всего последовательность состоит не более чем из 40 чисел.
 *
 * Последовательность завершается признаком конца ввода.
 *
 * На стандартный поток вывода напечатайте сумму этих чисел.
 **/
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int sum = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        while(scanner.hasNextInt()) {
            int number = scanner.nextInt();
            sum += number;
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }

        out.println(sum);

        out.flush();
        scanner.close();
    }
}
