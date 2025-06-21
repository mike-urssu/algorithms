package tags.math

/**
 * https://www.acmicpc.net/problem/1740
 */
fun main() {
    val n = readln().toLong()
    val binary = toReversedBinary(n)
    val v = binary.mapIndexed { i, v ->
        if (v == '1') {
            pow3(i)
        } else {
            0L
        }
    }.sumOf { it }
    println(v)
}

private fun toReversedBinary(n: Long): String {
    val b = StringBuilder()
    var remainder = n
    while (remainder > 1L) {
        b.append(remainder % 2L)
        remainder /= 2L
    }
    b.append(remainder)
    return b.toString()
}

private fun pow3(n: Int): Long {
    var v = 1L
    repeat(n) {
        v *= 3
    }
    return v
}
