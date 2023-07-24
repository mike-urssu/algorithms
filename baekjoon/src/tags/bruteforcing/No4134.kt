package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/4134
 */
import kotlin.math.sqrt

fun main() {
    val t = readln().toInt()
    repeat(t) {
        var n = readln().toLong()
        while (!isPrime(n)) {
            n++
        }
        println(n)
    }
}

private fun isPrime(n: Long): Boolean {
    when (n) {
        0L, 1L -> return false
        2L, 3L -> return true
        else -> {
            val sqrt = sqrt(n.toDouble()).toInt()
            for (i in 2..sqrt) {
                if (n % i == 0L) {
                    return false
                }
            }
        }
    }
    return true
}
