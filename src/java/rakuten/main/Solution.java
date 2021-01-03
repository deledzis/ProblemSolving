package java.rakuten.main;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) { }

    final static String VOWELS = "AEIOU";

    public static int solution(String S) {
        int size = S.length();

        // counting total number of vowels and consonants
        Stream<Character> characters = S.chars().mapToObj(c -> (char) c);
        int vowelsCount = (int) characters.filter(ch -> VOWELS.indexOf(ch) > -1).count();
        int consonantsCount = S.length() - vowelsCount;

        // Counting unique vowels and consonants
        Stream<Character> uniqueCharacters = S.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).stream();
        int vowelsUniqueCount = (int) uniqueCharacters.filter(ch -> VOWELS.indexOf(ch) >= 0).count();
        // need to reopen stream because of 'already closed' problem
        uniqueCharacters = S.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).stream();
        int consonantsUniqueCount = (int) uniqueCharacters.filter(ch -> VOWELS.indexOf(ch) < 0).count();

        if (size % 2 == 0) {
            // vowels count must be equal to consonant count
            if (consonantsCount != vowelsCount) return 0;
        } else {
            // vowels count must be less then consonant count
            if (vowelsCount > consonantsCount) return 0;
        }

        int vowelsMultiplier = vowelsUniqueCount == 1 ? 1 : vowelsCount * (vowelsUniqueCount - 1);
        int consonantsMultiplier = consonantsUniqueCount == 1 ? 1 : consonantsCount * (consonantsUniqueCount - 1);

        return vowelsMultiplier * consonantsMultiplier;
    }
}