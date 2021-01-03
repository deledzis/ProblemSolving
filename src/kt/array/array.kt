package kt.array

fun array(arr: Array<Int>) = arr.sorted().joinToString(",") { "$it" }

fun main() {
    println(array(arrayOf(3, 2, 1, 5, 6, -1, 10)))
}