package kt.reverse

/*
"QUICK FOX JUMPS"->"KCIUQ XOF SPMUJ"
"  QUICK FOX   JUMPS "->"  KCIUQ XOF   SPMUJ "
"  "->"  "
""->""
*/
fun reverseWithSplit(input: String): String = input.split(' ').joinToString(" ") { s ->
    if (s.matches(Regex("[A-Z]*"))) s.reversed()
    else throw Exception("Not a valid input string")
}

fun isLetter(c: Char): Boolean = c in 'A'..'Z'

fun reverseWord(input: String): String {
    var res = "${input[input.length - 1]}"
    for (i in 1 until input.length) {
        res += input[input.length - i - 1]
    }

    return res
}

fun getChar(input: String, idx: Int): Char {
    if (input[idx] == ' ' || isLetter(input[idx])) {
        return input[idx]
    } else {
        throw Exception("Not a valid input string")
    }
}

fun reverse(input: String): String {
    var fin = ""
    var buffer = ""
    var i = 0
    while (i < input.length) {

        if (getChar(input, i) == ' ') {
            fin += input[i]
            i++
            continue
        }

        while (isLetter(input[i]) && i < input.length) {
            buffer += input[i]
            if (i + 1 < input.length) i++
        }

        fin += reverseWord(buffer)
        buffer = ""
    }

    return fin
}

fun main() {
    println(reverse("QUICK FOX JUMPS "))
    println(reverse("  QUICK FOX   JUMPS "))
    println(reverse("  QWJ31s FOX   JUMPS "))
    println(reverseWithSplit("QUICK FOX JUMPS "))
    println(reverseWithSplit("  QUICK FOX   JUMPS "))
    println(reverseWithSplit("  QWJ31s FOX   JUMPS "))
}