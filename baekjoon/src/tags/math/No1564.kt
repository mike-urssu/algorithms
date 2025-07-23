package tags.math

/**
 * https://www.acmicpc.net/problem/1564
 */
fun main() {
    val n = readln().toInt()
    var factorial5 = 1L
    (1..n).forEach {
        factorial5 *= it
        while (factorial5 % 10 == 0L) {
            factorial5 /= 10
        }
        factorial5 %= 1_000_000_000_000
    }
    while (factorial5 % 10 == 0L) {
        factorial5 /= 10
    }
    println(String.format("%05d", factorial5 % 100000))
}
