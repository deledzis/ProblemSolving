package kt.parenthesis

import java.util.*

fun isOpen(i: Char): Boolean = (i == '(' || i == '{' || i == '[')
fun isClose(i: Char): Boolean = (i == ')' || i == '}' || i == ']')

fun getOppositeParenthesis(i: Char): Char {
    return when (i) {
        ')' -> '('
        '}' -> '{'
        ']' -> '['
        else -> throw IllegalArgumentException("Not an open parenthesis symbol")
    }
}

fun parenthesisTest(input: String): Boolean {
    val str = Stack<Char>()
    for (i in input) {
        if (isOpen(i)) {
            str.push(i)
        } else if (isClose(i)) {
            if (str.isEmpty()) return false
            val pop = str.pop()
            if (pop != getOppositeParenthesis(i)) return false
        }
    }

    return true
}

fun main() {
    println(parenthesisTest("{[}]"))
}