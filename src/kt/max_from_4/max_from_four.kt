package kt.max_from_4

fun maxFromFour(): Boolean {
    fun generateRandom(): Int {
        return (0..2_000_000_000).random()
    }

    val a = generateRandom().toLong().also { println("a = $it") }
    val b = generateRandom().toLong().also { println("b = $it") }
    val c = generateRandom().toLong().also { println("c = $it") }
    val d = generateRandom().toLong().also { println("d = $it") }
    val _1: Long = a * b + c * d
    val _2: Long = a * c + b * d
    val _3: Long = a * d + b * c
    val sorted = listOf(a, b, c, d).sortedDescending()
    val _4: Long = sorted[0] * sorted[1] + sorted[2] * sorted[3]
    println("using algo: $_4")
    println("using maxOf: ${maxOf(_1, _2, _3)}")
    return _4 == maxOf(_1, _2, _3)
}

fun main() {
    println(maxFromFour())
}