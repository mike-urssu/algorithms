package tags.math

/**
 * https://www.acmicpc.net/problem/15719
 */
fun main() {
    val n = readln().toInt()
    var sum1 = 0L
    while (true) {
        val v = read()
        if (v == -1) {
            break
        }
        sum1 += v
    }
    val sum2 = n.toLong() * (n - 1) / 2
    println(sum1 - sum2)
}

private fun read(): Int {
    var v = 0
    while (true) {
        val c = System.`in`.read()
        if (c == -1) {
            return -1
        }
        if (c == 10 || c.toChar() == ' ') {
            return v
        }
        v = v * 10 + c.toChar().digitToInt()
    }
}
