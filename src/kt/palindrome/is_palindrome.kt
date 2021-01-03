package kt.palindrome

import kotlin.math.abs

fun isLetterOrNumber(c: Char) = c in '0'..'9' || c in 'A'..'Z' || c in 'a'..'z' || c in 'а'..'я' || c in 'А'..'Я'

fun isPalindrome(input: String): Boolean {
    var i = 0
    var j = input.length - 1
    var res = false
    for (k in 0..input.length / 2) {
        while (!isLetterOrNumber(input[i]) && i < j) i++
        while (!isLetterOrNumber(input[j]) && j > i) j--
        println("k = $k, i = $i, j = $j || ${input[i]} ${input[j]}")
        if (input[i].toLowerCase() != input[j].toLowerCase()) {
            return false
        } else {
            if (isLetterOrNumber(input[i]) && isLetterOrNumber(input[j])) {
                res = true
            }
        }
        if (abs(i - j) < 2) break
        i++
        j--
    }
    return res
}

fun main() {
    println(isPalindrome("Madam I'm Adam")) // true
    println(isPalindrome("Dammit I'm Mad")) // true
    println(isPalindrome("AA]/;/;/,")) // true
    println(isPalindrome("]/;/;/,")) // true
    println(isPalindrome("Eva, can I see bees in a cave?")) // true
    println(isPalindrome("Ш4л4ш")) // true
}