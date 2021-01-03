package kt.count

fun getCount(str: String): Int = str.filter { it in "aeiou" }.length
fun getCountBest(str: String) = str.count { it in "aeiou" }

fun main() {
    println(getCount("asdaskjdjhajksda"))
}