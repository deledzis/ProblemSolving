package kt.remove_zeroes

fun removeZeroes(arr: Array<Int>): Int {
    var countNonZeroes = 0
    var lastNonZeroIndex = -1
    var i = 0
    while (i < arr.size) {
        println("i $i arr[i] = ${arr[i]}")
        if (arr[i] == 0) {
            // find first non zero element
            val j = if (lastNonZeroIndex > 0) lastNonZeroIndex else i + 1
            println("j $j arr[j] = ${arr[j]}")
            for (k in j..arr.size) {
                if (k < arr.size && arr[k] != 0) {
                    // swap arr[i] & arr[k]
                    countNonZeroes++
                    arr[i] = arr[k]
                    arr[k] = 0
                    lastNonZeroIndex = k + 1
                    println("lastNonZeroIndex = $lastNonZeroIndex")
                }
            }
        }
        i++
    }

    println(arr.toList())

    return countNonZeroes
}

fun main() {
    println(removeZeroes(arrayOf(0, 1, 2, 0, 0, 3, 0, 4, 0, 0, 5, 0)))
}