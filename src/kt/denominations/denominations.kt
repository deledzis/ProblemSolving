package kt.denominations

class Denomination(val coin: Int, var count: Int)

fun moneyChange(ret: Int, money: List<Denomination>): List<Int> {
    var _ret = ret
    var canReturn = 0
    val toGiveBack = MutableList(money.size) { 0 }
    money.sortedByDescending { it.coin }.forEachIndexed { i, d ->
        while (d.coin <= _ret && d.count > 0) {
            _ret -= d.coin
            canReturn += d.coin
            d.count--
            toGiveBack[i] += 1
        }
    }
    return if (canReturn == ret) toGiveBack else throw Exception("Невозможно выдать нужную сумму")
}

fun main() {
    val denominations = listOf(
        Denomination(5000, 4),
        Denomination(1000, 5),
        Denomination(500, 2),
        Denomination(100, 5),
        Denomination(50, 100),
        Denomination(30, 23),
    )

    println(moneyChange(780, denominations))
}