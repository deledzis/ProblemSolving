package kt.encode

fun encode(str: String): String {
    fun Int.length(): Int = "$this".length

    fun walker(c: Char, str: String): Pair<String, Int> {
        val res = str.substring(1).replace(c, '_')
        val count = res.count { it == '_' } + 1
        return if (count > 1) "$c$count${res.filterNot { it == '_' }}" to (count.length() + 1)
        else (c + res.filterNot { it == '_' }) to 1
    }

    if (str.isEmpty()) return ""
    val output = StringBuilder()
    var res = walker(str[0], str)
    while (true) {
        output.append(res.first.substring(0, res.second))
        if (res.first.length == res.second) break
        val substr = res.first.substring(res.second)
        res = walker(substr[0], substr)
    }
    return output.toString()
}

fun main() {
    println(encode(
        List(5) { 'A' }.joinToString("")
                + List(4) { 'B' }.joinToString("")
                + List(3) { 'A' }.joinToString("")
    ))
    println(encode("1015010651"))
}