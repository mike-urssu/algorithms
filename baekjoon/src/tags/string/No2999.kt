package tags.string

/**
 * https://www.acmicpc.net/problem/2999
 */
fun main() {
    val s = readln()
    val n = s.length
    var row = 0
    var col = 0
    for (i in 1..kotlin.math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            row = n / i
            col = i
        }
    }
    (0 until col).forEach { i ->
        (0 until row).forEach { j ->
            print(s[i + j * col])
        }
    }
}
