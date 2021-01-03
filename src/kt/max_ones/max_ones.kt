package kt.max_ones

import kotlin.math.max

/*
assert(maxOnes({0, 0}) == 0);
assert(maxOnes({1, 0}) == 1);
assert(maxOnes({0, 1}) == 1);
assert(maxOnes({1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1}) == 6);
assert(maxOnes({1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}) == 6);
3 2
*/
fun maxOnes(nums: List<Int>): Int {
    val neighbourOnes = mutableListOf<Int>()

    var i = 0
    var counterOnes = 0
    var counterZeroes = 0
    var maxCounterOnes = 0
    var zeroPresent = false
    while (i < nums.size) {
        if (nums[i] == 1) {
            if (counterOnes > 0 && counterZeroes == 1) {
                neighbourOnes.add(counterOnes)
                counterOnes = 0
            }
            while (i < nums.size && nums[i] == 1) {
                counterOnes++
                i++
            }
            if (counterOnes > maxCounterOnes) maxCounterOnes = counterOnes
            if (counterZeroes < 2) {
                neighbourOnes.add(counterOnes)
            }

            counterZeroes = 0
        } else if (nums[i] == 0) {
            i++
            zeroPresent = true
            counterZeroes++
            if (counterZeroes > 1) {
                counterOnes = 0
            }
        }
    }

    if (neighbourOnes.size < 3) return max(neighbourOnes.sumBy { it }, maxCounterOnes)
    println("neighbourOnes $neighbourOnes")

    var last = neighbourOnes.first()
    var maxVal = 0
    for (i in 1 until neighbourOnes.size) {
        if (last + neighbourOnes[i] > maxVal) maxVal = last + neighbourOnes[i]
        last = neighbourOnes[i]
    }
    println("maxVal $maxVal")
    println("maxCounterOnes $maxCounterOnes")

    maxVal = max(maxVal, maxCounterOnes)
    return if (!zeroPresent) maxVal - 1 else maxVal
}

fun main() {
    println(maxOnes(listOf(0, 0)) == 0)
    println(maxOnes(listOf(1, 0)) == 1)
    println(maxOnes(listOf(0, 1)) == 1)
    println(maxOnes(listOf(1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1)) == 6)
    println(maxOnes(listOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1)) == 6)
}