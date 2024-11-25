package tags.math

/**
 * https://www.acmicpc.net/problem/3474
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(countZeros(n))
    }
}

private fun countZeros(n: Int): Int {
    var count = 0
    var pow = 5
    while (pow <= n) {
        count += n / pow
        pow *= 5
    }
    return count
}
