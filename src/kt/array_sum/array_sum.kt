package kt.array_sum

fun arraySum(arr: Array<String>): Int {
    for (a in arr) {
        println(Integer.parseInt(a))
    }
    return 0
}

fun main() {
    arraySum(arrayOf("1", "2", "3x", "x4", ",3"))
}