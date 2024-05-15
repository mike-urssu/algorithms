package tags.math

/**
 * https://www.acmicpc.net/problem/11689
 */
import kotlin.math.sqrt

fun main() {
    val n = readln().toLong()
    println(eulerProductFormula(n))
}

private fun eulerProductFormula(n: Long): Long {
    return if (n == 1L) {
        1L
    } else if (isPrime(n)) {
        n - 1
    } else {
        var m = n
        var v = n
        (2..sqrt(n.toDouble()).toLong()).forEach { p ->
            if (m % p == 0L) {
                v = v / p * (p - 1)
                while (m % p == 0L) {
                    m /= p
                }
            }
        }
        if (m != 1L) {
            v = v / m * (m - 1)
        }
        v
    }
}

private fun isPrime(n: Long): Boolean {
    if (n == 1L) {
        return false
    }
    val pow = sqrt(n.toDouble()).toLong()
    for (i in 2..pow) {
        if (n % i == 0L) {
            return false
        }
    }
    return true
}
