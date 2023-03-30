package tags.string

/**
 * https://www.acmicpc.net/problem/15829
 */
fun main() {
    readln().toInt()
    val s = readln()
    var hash = 0L
    s.forEachIndexed { index, c ->
        val value = getValue((c - 'a' + 1).toLong(), index)
        hash = (hash + value) % 1234567891
    }
    println(hash)
}

private fun getValue(number: Long, index: Int): Long {
    var value = number
    for (i in 1..index) {
        value = value * 31 % 1234567891
    }
    return value
}
