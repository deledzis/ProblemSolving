package java.tinkoff_fintech.test.a;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * На стандартном потоке ввода задаются два целых числа, не меньшие
 *
 * -32000 и не большие 32000.
 *
 * На стандартный поток вывода напечатайте сумму этих чисел.
 *
 * Числа задаются по одному в строке. Пробельные символы перед числом и после
 *
 * него отсутствуют. Пустые строки в вводе отсутствуют.
 **/
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        short a = scanner.nextShort();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        short b = scanner.nextShort();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        out.println(a + b);

        out.flush();
        scanner.close();
    }
}
