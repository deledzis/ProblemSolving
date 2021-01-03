package java.rakuten.test;

import java.util.Arrays;
import java.util.Random;

class Solution {
    public  int solution(int[] A) {
        Arrays.sort(A);
        int currentMin = 1;
        for (int i : A) {
            if (i > currentMin) break;
            if (i == currentMin) currentMin++;
        }
        return currentMin;
    }

    public static void main(String[] args) {
//        int[] array = {1, 3, 6, 4, 1, 2};
        int[] array = new int[100_000];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = getRandomNumberUsingNextInt(-1_000_000, 1_000_000);
//        System.out.println(solution(array));
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
